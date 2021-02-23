package com.mayikt.service;

import com.mayikt.utils.MayiktRedisLock;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ThreadUtils;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: OrderService
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/11/2121:30
 */
public class OrderService {


    private static final String LOCKKEY = "mayikt_lock";

    public static void service() {
        // 1.获取锁
        MayiktRedisLock mayiktRedisLock = new MayiktRedisLock();
        String lockValue = mayiktRedisLock.getLock(LOCKKEY, 5000, 5000);
        if (StringUtils.isEmpty(lockValue)) {
            System.out.println(Thread.currentThread().getName() + "，获取锁失败了");
            return;
        }
        // 执行我们的业务逻辑
        System.out.println(Thread.currentThread().getName() + "，获取锁成功:lockValue:" + lockValue);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//
//        // 3.释放锁
        //mayiktRedisLock.unLock(LOCKKEY, lockValue);
    }

    public static void main(String[] args) {
        service();
    }


    /***
     *
     * 尝试获取锁为什么次数限制？
     * 如果我们业务逻辑5s 内没有执行完毕呢？
     *
     * 分场景：
     * 1.锁的超时时间根据业务场景来预估
     * 2.可以自己延迟锁的时间
     * 3.在提交事务的时候检查锁是否已经超时 如果已经超时则回滚（手动回滚）否则提交。
     *
     * 仅限于单机版本
     */
}
