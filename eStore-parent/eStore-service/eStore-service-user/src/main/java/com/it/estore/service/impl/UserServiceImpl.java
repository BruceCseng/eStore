package com.it.estore.service.impl;

import com.it.estore.dao.UserMapper;
import com.it.estore.service.UserService;
import com.it.estore.user.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO findById(String username) {
        return userMapper.selectByPrimaryKey(username);
    }
}
