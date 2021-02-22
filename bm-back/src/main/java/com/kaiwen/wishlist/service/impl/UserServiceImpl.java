package com.kaiwen.wishlist.service.impl;

import com.kaiwen.wishlist.dao.UserDAO;
import com.kaiwen.wishlist.entity.User;
import com.kaiwen.wishlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findByUserNameAndPassword(String username, String password) {
        return userDAO.findByUserNameAndPassword(username, password);
    }
}
