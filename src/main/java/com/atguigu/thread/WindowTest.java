/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 11:10
 */

package com.atguigu.thread;

//三个窗口买票，总票数100
public class WindowTest {

    public static void main(String[] args){

        Window w1 = new Window("w1");
        Window w2 = new Window("w2");
        Window w3 = new Window("w3");

        w1.start();
        w2.start();
        w3.start();

//        Window1 w1 = new Window1();
//        new Thread(w1).start();
//        new Thread(w1).start();
//        new Thread(w1).start();

    }

}

class Window extends Thread{

    private static int ticket =  100;

    public Window(String name) {
        super(name);
    }

    @Override
    public void run() {

        while (true){

            show();
        }
    }

    public static synchronized void show(){ // 同步监视器：Class clazz = Window.class
        if(ticket > 0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + "票号" + ticket);
            ticket --;
        }
    }
}

//synchronized synchronized synchronized synchronized
//synchronized(同步监视器){}
class Window1 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        while (true){

            synchronized (Window1.class){ // or window.class, this
                if(ticket > 0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " : " + "票号" + ticket);
                    ticket --;
                }else {
                    break;
                }
            }

        }
    }
}