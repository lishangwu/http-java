/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 10:33
 */

package com.atguigu.thread;

class MyRun implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0)
                System.out.println(i);
        }
    }
}

public class RunableTest {

    public static void main(String[] args){
        
        new Thread(new MyRun()).start();
                
    }

}
