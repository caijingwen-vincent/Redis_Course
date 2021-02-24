package com.mayikt.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: MemberEntity
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1621:01
 */
@Data
public class MemberEntity implements Serializable {
    private Long id;
    private String name;
    private Integer age;
}
