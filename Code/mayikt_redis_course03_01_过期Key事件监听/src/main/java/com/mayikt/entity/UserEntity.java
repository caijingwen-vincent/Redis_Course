package com.mayikt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: UserEntity
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1421:54
 */
@Data
public class UserEntity implements Serializable {
    private Long userId;
    private String userName;

}
