/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 14:12
 */

package com.atguigu.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * synchronized ReentrantLock 异同
 *
 * 都能解决线程安全
 *
 * synchronized 自动释放同步监视器
 * lock 手动启动同步， 手动结束
 *
 * */
class Window2 implements Runnable{

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){

            try {

                lock.lock();

                if(ticket > 0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + ticket);
                    ticket --;
                }else {
                    break;
                }
            }finally {
                lock.unlock();
            }

        }
    }
}

public class LockTest {

    public static void main(String[] args){

        Window2 w = new Window2();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.start();
        t2.start();
        t3.start();

    }

}
