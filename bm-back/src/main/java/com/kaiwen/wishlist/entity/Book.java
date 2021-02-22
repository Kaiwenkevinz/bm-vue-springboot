package com.kaiwen.wishlist.entity;

import lombok.Data;

@Data
public class Book {
    int id;
    String coverPath;
    String title;
    String author;
    String date;
    String press;
    String abs;
    int cid;
}
