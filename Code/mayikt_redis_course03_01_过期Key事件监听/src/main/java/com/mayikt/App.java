package com.mayikt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: App
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1421:58
 */
@SpringBootApplication
@EnableCaching
@MapperScan("com.mayikt.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

}
