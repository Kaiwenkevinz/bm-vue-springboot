package com.kaiwen.wishlist.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class User {
    int id;
    String username;
    String password;
}
