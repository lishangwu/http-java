/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 10:28
 */

package com.atguigu.thread;

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName()  + " "+ i);
        }
    }

}

public class ThreadTest{

    public static void main(String[] args){

        new MyThread().start();
        new MyThread().start();

        //匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                super.run();
            }
        }.start();

                
    }

}
