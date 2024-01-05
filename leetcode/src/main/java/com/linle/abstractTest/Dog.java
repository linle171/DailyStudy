package com.linle.abstractTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author chendeli
 * @Description:
 * @date 2023/3/6 14:37
 */
public class Dog extends Animal implements AnimalBehaviour{
    @Override
    void say() {
        /**
         * 一下为同步线程 在需要同步的⽅法上加上关键字synchronized
         * 这样做的代价是削弱了并发性，当多个线程共同竞争容器级的锁时，吞吐量就会降低
         */
        //数组 线程安全
        Vector<String> d = new Vector<>();
        //继承dictionary
        // 默认11
        // 扩容2n+1
        // 采用素数使数据尽量分布均匀 取hashcode就是使用jdk自带的方法 与hashMap不同
        // key 和 value 都不能为null
        // 线程安全
        // 为遗留类，和hashMap相似，性能比concurrentHashMap差 （使用了分段锁）
        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        //在list外面报了一层，对原来的方法加上synchronized
        List<Object> objects = Collections.synchronizedList(new ArrayList<>());
        //继承vector 外面封装了一层，在pop的时候是去length-1位（就是最后一位）
        Stack<String> strings = new Stack<>();


        /**
         * 解决同步容器的性能问题，所以才有了并发容器
         */
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();

    }

    @Override
    public void sort() {

    }
}
