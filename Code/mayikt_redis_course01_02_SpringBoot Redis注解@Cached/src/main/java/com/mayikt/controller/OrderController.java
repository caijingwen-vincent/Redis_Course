package com.mayikt.controller;

import com.mayikt.entity.OrderEntity;
import com.mayikt.mapper.OrderMapper;
import com.mayikt.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: OrderController
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1916:36
 */
@RestController
public class OrderController {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/saveOrder")
    public String saveOrder() {
        // 1.生成token
        String orderToken = UUID.randomUUID().toString();
        String orderId = System.currentTimeMillis() + "";
        //2. 将该token存放到redis中
        redisUtils.setString(orderToken, orderId, 15L);
        OrderEntity orderEntity = new OrderEntity(null, "蚂蚁课堂永久会员", orderId, orderToken);
        int result = orderMapper.insertOrder(orderEntity);
        return result > 0 ? "success" : "fail";
    }
}
