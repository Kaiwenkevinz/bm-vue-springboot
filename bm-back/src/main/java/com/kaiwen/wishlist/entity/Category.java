package com.kaiwen.wishlist.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Category implements Serializable {
    int id;
    String name;
}
