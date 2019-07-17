/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 14:59
 */

package com.atguigu.java2;

/**
 * 生产者消费者
 * */

class Clerk{
    private int count;

    public synchronized void add(){
        if(this.count < 20){
            this.count ++;
            System.out.println(Thread.currentThread().getName() + "  生产了 第 " + this.count + "个");

            notify();

        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sub(){
        if(this.count > 0){
            System.out.println(Thread.currentThread().getName() + "  消费了 第 " + this.count + "个");
            this.count --;

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

class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.add();
        }
    }
}

class Customer implements Runnable{

    private Clerk clerk;

    public Customer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.sub();
        }
    }
}

public class ProductTest {

    public static void main(String[] args){


        Clerk clerk = new Clerk();

        Productor productor = new Productor(clerk);
        Thread t1 = new Thread(productor);
        t1.setName("生产者");

        Customer customer = new Customer(clerk);
        Thread t2 = new Thread(customer);
        t2.setName("消费者");

        Customer customer2 = new Customer(clerk);
        Thread t3 = new Thread(customer2);
        t2.setName("消费者2");

        t1.start();
        t2.start();
        t3.start();
                
    }

}
