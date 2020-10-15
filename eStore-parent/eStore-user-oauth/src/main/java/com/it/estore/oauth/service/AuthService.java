package com.it.estore.oauth.service;

import com.it.estore.oauth.utils.AuthToken;

public interface AuthService {

    /***
     * 授权认证方法
     */
    AuthToken login(String username, String password, String clientId, String clientSecret);
}
