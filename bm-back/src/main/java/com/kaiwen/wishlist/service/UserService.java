package com.kaiwen.wishlist.service;

import com.kaiwen.wishlist.entity.User;

public interface UserService {
    User findByUserNameAndPassword(String username, String password);
}
