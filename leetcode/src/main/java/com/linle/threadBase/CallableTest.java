package com.linle.threadBase;

import java.util.concurrent.*;

/**
 * @description:
 * @author: chendeli
 * @date: 2023-10-23 09:19
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int availabled = Runtime.getRuntime().availableProcessors();
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
//        Thread thread = new Thread(futureTask);
//        thread.start();
//        String s = null;
//        try {
//            s = futureTask.get();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        } catch (ExecutionException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(s);


        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(availabled+1,availabled*2,20, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000));
        Future<String> submit = threadPoolExecutor.submit(myCallable);
        Object o = submit.get();
        System.out.println(o);
    }
}
