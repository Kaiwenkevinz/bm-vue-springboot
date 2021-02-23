package com.kaiwen.wishlist.cache;

import com.kaiwen.wishlist.utils.ApplicationContextUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Slf4j
@Data
public class RedisCache implements Cache {

    private RedisTemplate redisTemplate;
    private String id;

    public RedisCache(String id) {
        log.info("初始化缓存, 缓存id：[{}]", id);
        this.id = id;
    }


    @Override
    public void putObject(Object k, Object v) {
        log.info("放入缓存id：[{}]", this.id);
        log.info("放入缓存key：[{}], 放入缓存value：[{}]", k, v);
        this.getRedisTemplate().opsForHash().put(id, k.toString(), v);
    }

    @Override
    public Object getObject(Object k) {
        log.info("获取缓存id：[{}]", this.id);
        log.info("获取缓存key：[{}]", k);
        return getRedisTemplate().opsForHash().get(id, k.toString());
    }

    @Override
    public Object removeObject(Object o) {
        return null;
    }

    @Override
    public void clear() {
        log.info("清楚缓存");
        getRedisTemplate().delete(id);
    }

    @Override
    public int getSize() {
        return getRedisTemplate().opsForHash().size(id).intValue();
    }

    public RedisTemplate<String, Object> getRedisTemplate() {
        RedisTemplate redisTemplate = (RedisTemplate) ApplicationContextUtils.getBean("redisTemplate");
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        return redisTemplate;
    }
}
