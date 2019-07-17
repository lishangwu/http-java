/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 14:27
 */

package com.atguigu.thread;

class Account{
    private double banance;

    public Account(double banance) {
        this.banance = banance;
    }

    public synchronized void deposit(double amt){
        if(amt > 0){
            banance += amt;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " : deposit ok : " + banance);
        }
    }
}

class Customer extends Thread{

    private Account account;

    public Customer(Account account, String name) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {

        for (int i = 0; i < 3; i++) {
            account.deposit(1000);
        }

    }
}

public class AccountTest {

    public static void main(String[] args){
        
        Account account = new Account(0);
        new Customer(account, "A").start();
        new Customer(account, "B").start();
                
    }

}

