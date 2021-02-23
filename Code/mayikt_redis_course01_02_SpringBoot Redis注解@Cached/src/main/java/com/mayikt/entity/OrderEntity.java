package com.mayikt.entity;

import lombok.Data;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: OrderEntity
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1916:26
 */
@Data
public class OrderEntity {
    private Long id;
    private String orderName;
    /**
     * 0 待支付 1 已经支付
     */
    private Integer orderStatus;

    private String orderToken;
    private String orderId;

    public OrderEntity(Long id, String orderName, String orderId, String orderToken) {
        this.id = id;
        this.orderName = orderName;
        this.orderId = orderId;
        this.orderToken = orderToken;
    }
}
