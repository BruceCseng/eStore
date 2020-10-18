package com.it.estore.oauth.controller;

import com.it.estore.oauth.config.UserDetailsServiceImpl;
import com.it.estore.oauth.service.AuthService;
import com.it.estore.oauth.utils.AuthToken;
import com.it.estore.oauth.utils.CookieUtils;
import com.it.estore.user.feign.UserFeign;
import com.it.estore.user.vo.UserVO;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    //客户端ID
    @Value("${auth.clientId}")
    private String clientId;

    //秘钥
    @Value("${auth.clientSecret}")
    private String clientSecret;

    //Cookie存储的域名
    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    //Cookie生命周期
    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;

    @Autowired
    AuthService authService;

    @Autowired
    private UserFeign userFeign;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @PostMapping("/login")
    public Result login(String username, String password) {
        if (StringUtils.isEmpty(username)) {
            throw new RuntimeException("用户名不允许为空");
        }
        if (StringUtils.isEmpty(password)) {
            throw new RuntimeException("密码不允许为空");
        }
        //申请令牌
        AuthToken authToken = authService.login(username, password, username, password);
        //用户身份令牌
        String access_token = authToken.getAccessToken();
        //将令牌存储到cookie
        saveCookie(access_token);
        return new Result(true, StatueCode.SUCCESS_CODE, "登录成功！", access_token);
    }

    @PostMapping("/registry")
    public Result registry(@RequestBody UserVO userVO) {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String encode = bCrypt.encode(userVO.getPassword());
        userVO.setPassword(encode);
        userDetailsService.addOAuthInfo(userVO);
        userFeign.add(userVO);
        return new Result(true, StatueCode.SUCCESS_CODE, "注册成功");
    }

    /***
     * 将令牌存储到cookie
     * @param token
     */
    private void saveCookie(String token) {
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        CookieUtils.addCookie(response, cookieDomain, "/", "Authorization", token, cookieMaxAge, false);
    }
}
