package com.linle.concurrent.blockqueue;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author chendeli
 * @Description:
 * @date 2023/6/5 15:30
 */
public class TestPriorityBlockQueue {
    public static void main(String[] args) {
        PriorityBlockingQueue<AgeNum> pbq = new PriorityBlockingQueue<>();
        pbq.add(new AgeNum(1));
        pbq.add(new AgeNum(3));
        pbq.add(new AgeNum(2));

        pbq.remove();
    }
}
