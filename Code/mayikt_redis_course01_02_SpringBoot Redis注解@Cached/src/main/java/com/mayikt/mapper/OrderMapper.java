package com.mayikt.mapper;

import com.mayikt.entity.OrderEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: OrderMapper
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/1916:41
 */
public interface OrderMapper {

    @Insert("insert into order_number values (null,#{orderName},0,#{orderToken},#{orderId})")
    int insertOrder(OrderEntity OrderEntity);


    @Select("SELECT ID AS ID ,order_name AS ORDERNAME ,order_status AS orderstatus,order_token as ordertoken,order_id as  orderid FROM order_number\n" +
            "where order_token=#{orderToken};")
    OrderEntity getOrderNumber(String orderToken);

    @Update("\n" +
            "\n" +
            "update order_number set order_status=#{orderStatus} where order_token=#{orderToken};")
    int updateOrderStatus(String orderToken, Integer orderStatus);
}
