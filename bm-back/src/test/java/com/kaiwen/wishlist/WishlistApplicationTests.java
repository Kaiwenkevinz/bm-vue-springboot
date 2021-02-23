package com.kaiwen.wishlist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class WishlistApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void redisTest() {
        stringRedisTemplate.opsForValue().set("name", "李大强");
    }

}
