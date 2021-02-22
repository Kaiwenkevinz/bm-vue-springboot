package com.kaiwen.wishlist.dao;

import com.kaiwen.wishlist.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    User findByUserNameAndPassword(String username, String password);
}
