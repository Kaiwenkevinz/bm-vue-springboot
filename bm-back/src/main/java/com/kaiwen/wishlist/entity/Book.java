package com.kaiwen.wishlist.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {
    int id;
    String coverPath;
    String title;
    String author;
    String date;
    String press;
    String abs;
    int cid;
    Category category;
}
