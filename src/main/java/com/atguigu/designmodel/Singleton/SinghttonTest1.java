/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/10 18:07
 */

package com.atguigu.designmodel.Singleton;

public class SinghttonTest1 {

    public static void main(String[] args){
        
        Bank.getInstance();
                
    }

}

//饿汉模式
//线程安全
class Bank{

    private Bank(){}

    private static Bank instance = new Bank();

    public static Bank getInstance(){
        return instance;
    }
}
