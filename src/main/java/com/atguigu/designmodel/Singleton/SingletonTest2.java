/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/10 18:10
 */

package com.atguigu.designmodel.Singleton;

public class SingletonTest2 {

    public static void main(String[] args){
        

                
    }

}

//懒汉, 默认线程不安全
class Order{
    private Order(){}

    private static Order instance = null;

//    public static Order getInstance() {
//        if(instance == null)
//            return new Order();
//        return instance;
//    }

    public  static synchronized Order getInstance() {
        if(instance == null)
            return new Order();
        return instance;
    }

    public  static  Order getInstance2() {
        synchronized (Order.class) {//效率差
            if(instance == null)
                return new Order();
            return instance;
        }
    }

    public  static  Order getInstance3() {
        if (instance == null) {
            synchronized (Order.class) {//效率差
                if(instance == null)
                    instance = new Order();
            }
        }
        return instance;

    }
}