package com.atguigu.java8;

public interface CompareA {

    public static void method1(){
        System.out.println("CompareA.method1");
    }

    public default void method2(){
        System.out.println("CompareA.method2");
    }

}
