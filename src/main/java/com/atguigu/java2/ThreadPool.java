/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 16:02
 */

package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}

public class ThreadPool {

    public static void main(String[] args){

        ExecutorService service = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1 = (ThreadPoolExecutor) service;

        service1.setCorePoolSize(15);
//        service1.setKeepAliveTime();


        service.execute(new NumberThread()); // 适合Runable
        service.execute(new NumberThread1()); // 适合Runable
//        service.submit(); // 适合Callable

        service.shutdown();

    }


}
