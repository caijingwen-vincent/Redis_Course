package com.mayikt;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.UserEntity;
import com.mayikt.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisController {


    @Autowired
    private RedisUtils redisUtils;

    @GetMapping("/addUser")
    public String addUser(UserEntity userEntity) {
        // 1.将我们的对象转换成json
        String json = JSONObject.toJSONString(userEntity);
        redisUtils.setString("userEntity", json);
        return "存储成功~";
    }

    @RequestMapping("/getUser")
    public UserEntity getUser(String key) {
        String json = redisUtils.getString(key);
        UserEntity userEntity = JSONObject.parseObject(json, UserEntity.class);
        return userEntity;
    }
}
