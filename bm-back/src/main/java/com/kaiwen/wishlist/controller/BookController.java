package com.kaiwen.wishlist.controller;

import com.kaiwen.wishlist.entity.Book;
import com.kaiwen.wishlist.entity.Result;
import com.kaiwen.wishlist.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("api")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("books")
    public List<Book> list() {
        log.info("api/books接口");
        return bookService.findAll();
    }
}
