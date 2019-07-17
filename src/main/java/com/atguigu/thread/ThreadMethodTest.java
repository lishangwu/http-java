/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 10:44
 */

package com.atguigu.thread;

//yield,join, stop(过时), sleep, isAlive

class HelloThread extends Thread{

    public HelloThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {

            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName()  + " "+ i);

            if(i % 20 == 0)
                yield();// 释放当前cup的执行权
        }
    }
}

public class ThreadMethodTest {

    public static void main(String[] args){

        
        HelloThread h = new HelloThread("sb");

        h.setPriority(Thread.MAX_PRIORITY);
        h.setPriority(9);

        h.start();

        Thread.currentThread().setName("main");
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName()  + " "+ i);

            if(i == 20)
                try {
                    h.join();//h 执行完后 执行main
//                    线程a调用b的join()， a进入阻塞状态，直到b执行完后，a结束阻塞状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }

        System.out.println(h.isAlive());

        System.out.println(Thread.currentThread().getPriority());
        System.out.println(h.getPriority());

    }

}
