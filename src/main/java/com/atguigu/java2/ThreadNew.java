/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 15:47
 */

package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0){
                sum += i;
            }
        }

        return sum;
    }
}

public class ThreadNew {


    public static void main(String[] args){
        
        NumThread nt = new NumThread();


        FutureTask f = new FutureTask(nt);

        new Thread(f).start();

        try {
            Object sum = f.get();

            System.out.println(sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
