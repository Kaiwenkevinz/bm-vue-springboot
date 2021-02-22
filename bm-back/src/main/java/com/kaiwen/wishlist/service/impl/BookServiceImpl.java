package com.kaiwen.wishlist.service.impl;

import com.kaiwen.wishlist.dao.BookDAO;
import com.kaiwen.wishlist.entity.Book;
import com.kaiwen.wishlist.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }
}
