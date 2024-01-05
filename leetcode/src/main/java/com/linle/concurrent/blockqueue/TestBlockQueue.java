package com.linle.concurrent.blockqueue;

/**
 * @author chendeli
 * @Description:
 * @date 2023/6/5 10:08
 */
public class TestBlockQueue {
    static Integer i = 1;
    String s;

    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<Integer> abq = new ArrayBlockingQueue(10);
//        abq.put(1);
//        abq.put(2);
//        abq.put(3);
//        abq.put(4);
//
//        Integer take = abq.take();
//        System.out.println(take);
//
//        abq.take();
        TestBlockQueue testBlockQueue = new TestBlockQueue();
        int y = 0b00011111;
        System.out.println(i);
        System.out.println(128 >>> 3);
        int x = 0b1111111;
        System.out.println(x);
        System.out.println(x >>> 3);
        System.out.println("--" + (5 & 7));
        System.out.println("--" + (5 % 8));

        int c,d,e;
        c= 1;
        d =2;
        e=0;
        if(c == 1 || d == (e = 1)){
            System.out.println(e);
        }

    }
}
