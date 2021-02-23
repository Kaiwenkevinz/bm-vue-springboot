package com.kaiwen.wishlist.controller;

import com.kaiwen.wishlist.entity.Result;
import com.kaiwen.wishlist.entity.User;
import com.kaiwen.wishlist.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("api")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     */
    @PostMapping("login")
    public Result login(@RequestBody User userReq) {
        log.info("login 接口");
        log.info("前端传入用户：[{}]", userReq);

        String username = userReq.getUsername();
        User user = userService.findByUserNameAndPassword(username, userReq.getPassword());

        log.info("找到user：[{}]", user);

        if (user != null) {
            return new Result(200, "登录成功!");
        } else {
            return new Result(400, "登录失败!");
        }
    }

}
