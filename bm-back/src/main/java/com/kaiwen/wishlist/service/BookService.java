package com.kaiwen.wishlist.service;

import com.kaiwen.wishlist.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    void save(Book book);

    void delete(int id);

    void update(Book book);

    List<Book> findByCategory(int cid);

    List<Book> selectBykeyWord(String keyword);
}
