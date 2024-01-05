package com.linle.threadBase;

import java.util.concurrent.Callable;

/**
 * @description:
 * 第一种方法：
 * MyCallable myCallable = new MyCallable();
 * FutureTask<String> futureTask = new FutureTask<>(myCallable);
 * Thread thread = new Thread(futureTask);
 * thread.start();
 * futureTask.get()
 *
 * 第二种方法：
 * int availabled = Runtime.getRuntime().availableProcessors();
 * ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availabled+1,availabled*2,20, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000));
 * Future<String> submit = threadPoolExecutor.submit(myCallable);
 *
 * @author: chendeli
 * @date: 2023-10-23 09:21
 */
public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "callable---";
    }
}
