/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 21:41
 */

package com.atguigu.Lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest1 {

    @Test
    public void test(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("sb..");
            }
        };

        r1.run();

        System.out.println("******************************");

        Runnable r2 = () -> System.out.println("sb..2");

        r2.run();

        System.out.println("******************************");

    }

    @Test
    public void test2(){

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        System.out.println(comparator.compare(1, 2));

        System.out.println("******************************");

        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);

        System.out.println(comparator2.compare(1, 2));

        System.out.println("******************************");

        Comparator<Integer> comparator3 = Integer :: compare;

        System.out.println(comparator3.compare(1, 2));

    }

    @Test
    public void test3(){

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumer.accept("sb....");

        System.out.println("******************************");

        Consumer<String> consumer2 = (String s) -> System.out.println(s);
        consumer2.accept("sb2");


    }

    //类型推断
    @Test
    public void test4(){

        Consumer<String> consumer2 = (String s) -> {
            System.out.println(s);
        };
        consumer2.accept("sb2");

        System.out.println("******************************");

        Consumer<String> consumer3 = (s) -> {
            System.out.println(s);
        };
        consumer3.accept("sb2");

    }

    @Test
    public void test5(){

        Consumer<String> consumer3 = s -> {
            System.out.println(s);
        };
        consumer3.accept("sb2");

    }

    @Test
    public void test6(){

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        System.out.println(comparator.compare(1, 2));

        System.out.println("******************************");

        Comparator<Integer> com2 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        System.out.println(com2.compare(1, 2));

    }

    @Test
    public void test7(){

        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(1, 2));

    }

}
