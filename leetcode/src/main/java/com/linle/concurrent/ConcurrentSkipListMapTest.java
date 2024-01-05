package com.linle.concurrent;

import javax.xml.transform.Source;
import java.util.NavigableSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chendeli
 * @Description:
 * @date 2023/6/13 10:13
 */
public class ConcurrentSkipListMapTest {
    public static void main(String[] args) {
        ConcurrentSkipListMap map = new ConcurrentSkipListMap();
        map.put(1, 2);
        NavigableSet navigableSet = map.keySet();
        System.out.println(navigableSet);

        Object o = map.get(1);
    }

}
