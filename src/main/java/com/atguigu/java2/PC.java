/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 15:28
 */

package com.atguigu.java2;


class Bucket{

    private int count;

    public synchronized void add() {
        if(count < 20){
            count ++;
            System.out.println("开始生产 第" + count + "个");

            notify();

        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sub() {
        if(count > 0){
            System.out.println("开始消费 第" + count + "个.........");
            count --;

            notify();

        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PP extends Thread{

    private Bucket bucket;

    public PP(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        System.out.println("PP ....");
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bucket.add();
        }
    }
}

class CC extends Thread{

    private Bucket bucket;

    public CC(Bucket bucket) {
        this.bucket = bucket;
    }

    @Override
    public void run() {
        System.out.println("CC ....");
        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bucket.sub();
        }
    }
}

public class PC {

    public static void main(String[] args){


        Bucket b = new Bucket();

        PP p = new PP(b);
        p.setName("PP");

        CC c = new CC(b);
        c.setName("CC");
        CC c2 = new CC(b);
        c.setName("CC2");

        p.start();
        c.start();
        c2.start();

                
    }

}
