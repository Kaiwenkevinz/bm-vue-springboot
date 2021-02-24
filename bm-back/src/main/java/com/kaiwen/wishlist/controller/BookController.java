package com.kaiwen.wishlist.controller;

import com.kaiwen.wishlist.entity.Book;
import com.kaiwen.wishlist.entity.Result;
import com.kaiwen.wishlist.entity.User;
import com.kaiwen.wishlist.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("api")
public class BookController {

    @Autowired
    private BookService bookService;

    @Value("${file.filepath}")
    private String filepath;

    /**
     * 根据页面数返回书籍
     */
    @GetMapping("books/page/{pageNum}")
    public List<Book> listByPage(@PathVariable("pageNum") int pageNum) {
        log.info("api/books/page接口, pageNum: [{}]", pageNum);
        return bookService.listByPage((pageNum - 1) * 5);
    }

    /**
     * 根据种类返回图书总数
     */
    @GetMapping("books/count/{cid}")
    public int countByCategory(@PathVariable("cid") int cid) {
        log.info("count接口, cid: [{}]", cid);
        return bookService.count(cid);
    }


        /**
         * 添加图书
         */
    @PostMapping("books/add")
    public Result add(@RequestBody Book book) {
        log.info("添加图书接口");
        log.info("收到前端图书：[{}]", book.toString());
        try {
            bookService.save(book);
            return new Result(200, "图书添加成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(400, "图书添加失败！");
        }
    }

    /**
     * 删除图书
     */
    @PostMapping("/books/delete")
    public void delete(@RequestBody Book book) {
        log.info("删除图书id: [{}]", book.getId());
        bookService.delete(book.getId());
        this.deleteBookCover(book.getCoverPath());
    }

    private void deleteBookCover(String url) {
        String path = "C:\\IDEAworkspace\\bm-vue-springboot\\images\\" + url.substring(url.lastIndexOf("/") + 1);
        log.info("删除图片: [{}]", path);
        File file = new File(path);
        if (file.exists()) {
            file.delete();
            log.info("删除图片成功");
        }
    }


    /**
     * 更新图书
     */
    @PostMapping("books/update")
    public void update(@RequestBody Book book) {
        log.info("更新图书: [{}]", book);
        try {
            bookService.update(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据种类获取图书
     */
    @GetMapping("categories/{cid}/books/{pageNum}")
    public List<Book> findBooksByCategory(@PathVariable("cid") int cid, @PathVariable("pageNum") int pageNum) {
        log.info("根据种类查找图书：[{}]", cid);
        if (cid == 0) {
            return this.listByPage(pageNum);
        } else {
            return bookService.findByCategory((pageNum - 1) * 5, cid);
        }
    }


    /**
     * 上传图片
     */
    @PostMapping("books/uploadimage")
    public String bookImageUpload(MultipartFile file) throws Exception {
        log.info("前端传来的图片：[{}]", file);
        log.info("图片本地地址：[{}]", filepath);

        String folderPath = filepath;
        File folder = new File(folderPath);
        String name = UUID.randomUUID() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        File newFile = new File(folder, name);

        if (!newFile.getParentFile().exists()) {
            newFile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(newFile);
            return "http://localhost:8989/bm/api/file/" + newFile.getName();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    /**
     * 模糊搜索
     */

    @GetMapping("search")
    public List<Book> findBooksByCategory(@RequestParam String keyword) {
        log.info("模糊查找图书：[{}]", keyword);
        return bookService.selectBykeyWord(keyword);
    }
}
