package com.kaiwen.wishlist.service;

import com.kaiwen.wishlist.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {
    void save(Book book);

    void delete(int id);

    void update(Book book);

    List<Book> findByCategory(int offset, int cid);

    List<Book> selectBykeyWord(String keyword);

    List<Book> listByPage(int pageNum);

    int count(int cid);
}
