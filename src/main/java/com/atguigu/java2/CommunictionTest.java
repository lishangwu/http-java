/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 14:39
 */

package com.atguigu.java2;

class Number implements Runnable{

    private int num = 1;

    private Object obj = new Object();
    @Override
    public void run() {
//        synchronized (this){
//            if(num <= 100){
//                for (int i = 1; i <= 100; i++) {
//                    System.out.println(Thread.currentThread().getName() + " : " + (num++));
//                }
//            }
//        }

        //wait notify notifyAll 必须在synchronized内
        //三个调用者必须是synchronized(obj)里的obj（同步监视器）

//        sleep wait 异同


        while (true){
            synchronized (obj) {

                obj.notify();//唤醒被wait的线程

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(num <= 100){
                    System.out.println(Thread.currentThread().getName() + " : " + num);
                    num ++;
                }

                try {
                    obj.wait(); //会释放锁  进入阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }


    }
}

public class CommunictionTest {

    public static void main(String[] args){

        Number number = new Number();

        new Thread(number).start();
        new Thread(number).start();
                
    }


}
