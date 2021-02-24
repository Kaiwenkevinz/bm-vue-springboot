package com.kaiwen.wishlist.dao;

import com.kaiwen.wishlist.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookDAO {

    void save(Book book);

    List<Book> listByPage(int offset);

    void delete(int id);

    void update(Book book);

    int count(int cid);

    List<Book> findByCategory(int offset, int cid);

    List<Book> selectBykeyWord(@Param("keyword") String keyword);
}
