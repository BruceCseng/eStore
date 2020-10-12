package com.it.estore.service;

import com.it.estore.user.vo.UserVO;

public interface UserService {

    UserVO findById(String username);
}
