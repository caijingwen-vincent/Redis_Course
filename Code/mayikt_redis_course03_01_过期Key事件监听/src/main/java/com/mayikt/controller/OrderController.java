package com.mayikt.controller;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.mayikt.entity.OrderEntity;
import com.mayikt.entity.UserEntity;
import com.mayikt.mapper.OrderMapper;
import com.mayikt.utils.RedisTemplateUtils;
import com.mayikt.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: OrderController
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1921:27
 */
@RestController
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/addOrder")
    public String addOrder() {
        // 1.提前生成订单token 临时且唯一
        String orderToken = UUID.randomUUID().toString();
        Long orderId = System.currentTimeMillis();
        // 2.将我们的token存放到rdis中
        redisUtils.setString(orderToken, orderId + "", 10L);
        OrderEntity orderEntity = new OrderEntity(null, "蚂蚁课堂永久会员", orderId + "", orderToken);
        return orderMapper.insertOrder(orderEntity) > 0 ? "success" : "fail";
    }
}
