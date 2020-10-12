package com.it.estore.controller;

import com.alibaba.fastjson.JSON;
import com.it.estore.service.UserService;
import com.it.estore.user.vo.UserVO;
import com.it.estore.utils.BCrypt;
import com.it.estore.utils.JwtUtils;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result login(String username, String password, HttpServletResponse response){
        UserVO userVO = userService.findById(username);
        if(BCrypt.checkpw(password,userVO.getPassword())){
            // 创建用户令牌信息
            Map<String,Object> userInfo = new HashMap<>();
            userInfo.put("role","USER");
            userInfo.put("success","SUCCESS");
            userInfo.put("username",username);
            // 生成令牌
            String token = JwtUtils.createJWT(UUID.randomUUID().toString(), JSON.toJSONString(userInfo), null);
            // 存入cookie
            Cookie cookie = new Cookie("Authorization",token);
            cookie.setDomain("localhost");
            cookie.setPath("/");
            response.addCookie(cookie);
            // 传给用户
            return new Result(true, StatueCode.SUCCESS_CODE,"登录成功",token);
        }
        return new Result(false, StatueCode.NO_PERMISSION_CODE,"用户名或密码输入错误");
    }
}
