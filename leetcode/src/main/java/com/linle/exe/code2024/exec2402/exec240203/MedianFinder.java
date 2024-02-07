package com.linle.exe.code2024.exec2402.exec240203;

import org.junit.Test;

import java.util.*;

/**
 * @description: 295. 数据流的中位数 difficult
 * @author: chendeli
 * @date: 2024-02-03 13:41
 */
public class MedianFinder {
    /**
     * 中位数是有序整数列表中的中间值。如果列表的大小是偶数，则没有中间值，中位数是两个中间值的平均值。
     * <p>
     * 例如 arr = [2,3,4] 的中位数是 3 。
     * 例如 arr = [2,3] 的中位数是 (2 + 3) / 2 = 2.5 。
     * 实现 MedianFinder 类:
     * <p>
     * MedianFinder() 初始化 MedianFinder 对象。
     * <p>
     * void addNum(int num) 将数据流中的整数 num 添加到数据结构中。
     * <p>
     * double findMedian() 返回到目前为止所有元素的中位数。与实际答案相差 10-5 以内的答案将被接受。
     * <p>
     * 示例 1：
     * <p>
     * 输入
     * ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
     * [[], [1], [2], [], [3], []]
     * 输出
     * [null, null, null, 1.5, null, 2.0]
     * <p>
     * 解释
     * MedianFinder medianFinder = new MedianFinder();
     * medianFinder.addNum(1);    // arr = [1]
     * medianFinder.addNum(2);    // arr = [1, 2]
     * medianFinder.findMedian(); // 返回 1.5 ((1 + 2) / 2)
     * medianFinder.addNum(3);    // arr[1, 2, 3]
     * medianFinder.findMedian(); // return 2.0
     * 提示:
     * <p>
     * -105 <= num <= 105
     * 在调用 findMedian 之前，数据结构中至少有一个元素
     * 最多 5 * 104 次调用 addNum 和 findMedian
     */
    @Test
    public void test() {
        MedianFinder m = new MedianFinder();
        m.addNum(1);
        m.addNum(2);
        double median = m.findMedian();
        m.addNum(4);
        m.addNum(3);
        m.addNum(5);
    }

    Queue<Integer> maxDeque;
    Queue<Integer> minDeque;

    int size = 0;


    public MedianFinder() {
        maxDeque = new PriorityQueue<>(Comparator.reverseOrder());
        minDeque = new PriorityQueue<>();
    }

    /**
     *
     * 解题思路：
     * 维护一个大小堆，去中间值
     * @param num
     */
    public void addNum(int num) {
        int temp = num;
        if (!minDeque.isEmpty()) {
            if (num > minDeque.peek()) {
                Integer poll = minDeque.poll();
                temp = poll;

                minDeque.add(num);
            }
        }
        maxDeque.add(temp);
        size++;
        while (maxDeque.size() - minDeque.size() > 1) {
            Integer poll = maxDeque.poll();
            minDeque.add(poll);
        }
    }

    public double findMedian() {
        return size % 2 == 0 ? (maxDeque.peek() + minDeque.peek()) / 2.0 : maxDeque.peek();
    }
}
