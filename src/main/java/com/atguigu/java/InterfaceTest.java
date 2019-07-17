/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 01:54
 */

package com.atguigu.java;

public class InterfaceTest {

    public static void main(String[] args){

        System.out.println(Flyable.MAX_SPEED);

    }

}

interface Flyable{

    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1;

    public abstract void fly();
    void stop();




}


class Plane implements Flyable{

    @Override
    public void fly() {

    }

    @Override
    public void stop() {

    }
}