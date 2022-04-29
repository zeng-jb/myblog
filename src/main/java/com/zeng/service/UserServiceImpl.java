package com.zeng.service;

import com.zeng.dao.UserDao;
import com.zeng.pojo.User;
import com.zeng.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class   UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
