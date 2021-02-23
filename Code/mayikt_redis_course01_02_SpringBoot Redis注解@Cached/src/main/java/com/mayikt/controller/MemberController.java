package com.mayikt.controller;

import com.mayikt.entity.MemberEntity;
import com.mayikt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: MemberController
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1621:03
 */
@RestController
public class MemberController {
    @Autowired
    private UserMapper userMapper;

    /**
     * cacheNames：<br>
     * key：<br?>
     *
     * @return
     */
    @Cacheable(cacheNames = "members", key = "'getListMembers'")
    @RequestMapping("/getListMembers")
    public List<MemberEntity> getListMembers() {
        return userMapper.findMemberAll();
    }
  //
}
