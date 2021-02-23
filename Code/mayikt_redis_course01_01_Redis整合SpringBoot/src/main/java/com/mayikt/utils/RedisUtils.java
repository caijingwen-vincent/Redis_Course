package com.mayikt.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: RedisUtils
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1421:47
 */
@Component
public class RedisUtils {

    /**
     * 获取我们的redis模版
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    public void setString(String key, String value) {
        setString(key, value, null);
    }

    public void setString(String key, String value, Long timeOut) {
        stringRedisTemplate.opsForValue().set(key, value);
        if (timeOut != null) {
            stringRedisTemplate.expire(key, timeOut, TimeUnit.SECONDS);
        }
    }


    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    /**
     * redis当成数据库中
     *
     * 注意事项：对我们的redis的key设置一个有效期
     */


}
