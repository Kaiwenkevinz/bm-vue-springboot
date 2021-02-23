package com.kaiwen.wishlist.dao;

import com.kaiwen.wishlist.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDAO {

    void save(Book book);

    List<Book> findAll();

    void delete(int id);
}
