package com.fan.jmm.thread;

public class VolatileTest {
    private volatile  static int NUM1 = 0;
    private volatile  static int NUM2 = 0;
    
    public  static void main(String[] args) {
       test1();
       test2();
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：上午11:34:43</li>
     * <li>3、作          者：fan</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：这个方法演示了Volatile的使用方法，虽然volatile修饰的内容是多个线程同时可见的，但是
     * 如果多个线程同时去修改，那么并不能保证其线程安全，因为对volatile修饰的内容修改后虽然对所有线程可见，但是
     * 每个线程对volatile修饰的内容修改也是通过copy变量的副本到该线程的工作内存进行修改，然后再将修改后的值同步
     * 到volatile修饰的变量，同步后即所有线程都可见
     * </li>
     * <li>6、方法说明：</li>
     * </ul>
     */
    private static void test1(){
        Thread [] threadArray = new Thread[20];
        for(int i = 0; i < threadArray.length; i++){
            threadArray[i] = new Thread(new Runnable() {
                public void run() {
                    for(int j = 0; j < 10000; j++){
                        NUM1 ++;
                    }
                }
            });
            threadArray[i].start();
        }
        while(Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(NUM1);
    }
    
    /**
     * <ul>
     * <li>1、开发日期：2018年1月24日</li>
     * <li>2、开发时间：下午12:40:02</li>
     * <li>3、作          者：fan</li>
     * <li>4、返回类型：void</li>
     * <li>5、方法含义：针对test1的非线程安全的情况增加如下synchronized关键字修改volatile修饰的变量部分锁住即可</li>
     * <li>6、方法说明：</li>
     * </ul>
     */
    private static void test2(){
        Thread [] threadArray = new Thread[20];
        for(int i = 0; i < threadArray.length; i++){
            threadArray[i] = new Thread(new Runnable() {
                public void run() {
                    for(int j = 0; j < 10000; j++){
                        synchronized (VolatileTest.class) {
                            NUM2 ++;
                        }
                    }
                }
            });
            threadArray[i].start();
        }
        while(Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(NUM2);
    }
}
