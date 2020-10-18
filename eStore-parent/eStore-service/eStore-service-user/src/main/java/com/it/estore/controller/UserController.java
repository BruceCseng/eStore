package com.it.estore.controller;

import com.it.estore.service.UserService;
import com.it.estore.user.vo.UserVO;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public Result add(@RequestBody UserVO userVO){
        userService.add(userVO);
        return new Result(true,StatueCode.SUCCESS_CODE,"注册成功");
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
        return new Result<>(true, StatueCode.SUCCESS_CODE, "查询成功", user);
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
