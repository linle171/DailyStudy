package com.linle.concurrent.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chendeli
 * @Description:
 * @date 2023/6/13 14:14
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock rl = new ReentrantLock();
        try {
            rl.lock();
        }finally {
            rl.unlock();
        }

    }
}
