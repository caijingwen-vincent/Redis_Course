package com.mayikt;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.ArrayList;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: BlongTest
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/12/221:26
 */
public class BlongTest {

    /**
     * 假设集合中存放100万条数据
     */
    private static Integer size = 1000000;

    public static void main(String[] args) {
        BloomFilter<Integer> integerBloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, 0.0000000001);
        for (int i = 0; i < size; i++) {
            // 向我们布隆过滤器中存放100万条数据
            integerBloomFilter.put(i);
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int j = size; j < size + 10000; j++) {
            // 使用该pai判断key在布隆过滤器中是否存在 返回true 存在 false  表示不存在
            if (integerBloomFilter.mightContain(j)) {
                // 将布隆过滤器误判的结果存放到集合中方便后期统计
                integers.add(j);
            }
        }
        System.out.println("布隆过滤器误判的结果:" + integers.size());
        // 0.03概率 数组长度730万左右 0.01
        // 0.01概率 数组长度960万左右
    }
}
