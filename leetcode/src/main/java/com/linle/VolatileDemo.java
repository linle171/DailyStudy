package com.linle;

import java.util.concurrent.TimeUnit;

 public class VolatileDemo {
    public static void main(String[] args) {//main是一切方法的运行入口
        MyData myData = new MyData();//资源类
        new Thread(() ->{
            System.out.println(
                    Thread.currentThread().getName()+"\t come in");
//暂停一会儿线程
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(
                    Thread.currentThread().getName()+
                            "\t update number value:"+ myData.number);
        },"AAA").start();
//第二个线程就是我们的main线程
        while (myData.number == 0){
//main线程就一直在这里等待，直到number值不再等于0
            System.out.println(myData.number);
        }
        System.out.println(Thread.currentThread().getName()+
                        "mission is over, main get number value:" + myData.number);
    }
}

class MyData{ int number = 0;
    public void addTo60(){
        this.number = 60;
    }
}
