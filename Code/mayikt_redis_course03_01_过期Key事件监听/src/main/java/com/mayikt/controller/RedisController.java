package com.mayikt.controller;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.UserEntity;
import com.mayikt.utils.RedisTemplateUtils;
import com.mayikt.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: RedisController
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1421:54
 */
@RestController
public class RedisController {


    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplateUtils redisTemplateUtils;

    @GetMapping("/addUser")
    public String addUser(UserEntity userEntity) {
        // 1.将我们的对象转换成json
//        String json = JSONObject.toJSONString(userEntity);
//        redisUtils.setString("userEntity", json);
        redisTemplateUtils.setObject("userEntity", userEntity);
        return "存储成功~";
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(String key) {
//        String json = redisUtils.getString(key);
//        UserEntity userEntity = JSONObject.parseObject(json, UserEntity.class);
        return (UserEntity) redisTemplateUtils.getObject(key);
    }

}
