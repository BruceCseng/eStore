package com.it.estore.controller;

import com.alibaba.fastjson.JSON;
import com.it.estore.service.UserService;
import com.it.estore.user.vo.UserVO;
import com.it.estore.utils.BCrypt;
import com.it.estore.utils.JwtUtils;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<UserVO> login(String username, String password, HttpServletResponse response) {
        //1.从数据库中查询用户名对应的用户的对象
        UserVO user = userService.findById(username);
        if (user == null) {
            //2.判断用户是否为空 为空返回数据
            return new Result<UserVO>(false, StatueCode.LOGIN_FAIL_CODE, "用户名或密码错误");
        }

        //3如果不为空格 判断 密码是否正确 正确则登录成功

        if(BCrypt.checkpw(password,user.getPassword())){
            //成功
            Map<String,Object> info = new HashMap<>();
            info.put("role","USER");
            info.put("success","SUCCESS");
            info.put("username",username);

            //1.生成令牌
            String jwt = JwtUtils.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(info), null);
            //2.设置cookie中
            Cookie cookie = new Cookie("Authorization",jwt);
            response.addCookie(cookie);
            //3.设置头文件中
            response.setHeader("Authorization",jwt);

            return new Result<UserVO>(true, StatueCode.SUCCESS_CODE, "成功",jwt);
        }else{
            //失败
            return new Result<UserVO>(false, StatueCode.LOGIN_FAIL_CODE, "用户名或密码错误");
        }
    }

    /**
     * 加载用户的数据
     * @param id
     * @return
     */
    @GetMapping("/load/{id}")
    public Result<UserVO> findByUsername(@PathVariable(name="id") String id) {
        //调用UserService实现根据主键查询User
        UserVO user = userService.findById(id);
        return new Result<UserVO>(true, StatueCode.SUCCESS_CODE, "查询成功", user);
    }

    /***
     *
     * 希望 拥有admin的角色人才能访问.
     * 查询User全部数据
     * @return
     */
    @PreAuthorize(value="hasAuthority('goods_list')")
    // @PreAuthorize 表示 在执行方法之前 先进行权限校验,只有拥有 admin角色的用户可以执行该方法.
    @GetMapping
    public Result<List<UserVO>> findAll(HttpServletRequest request) {
        System.out.println("头信息为:"+request.getHeader("Authorization"));
        //调用UserService实现查询所有User
        List<UserVO> list = userService.findAll();
        return new Result<>(true, StatueCode.SUCCESS_CODE, "查询成功", list);
    }


}
