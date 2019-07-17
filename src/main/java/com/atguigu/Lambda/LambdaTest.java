/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 21:41
 */

package com.atguigu.Lambda;

import org.junit.Test;

import java.util.Comparator;

public class LambdaTest {

    @Test
    public void test(){

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("sb..");
            }
        };

        r1.run();

        System.out.println();

        Runnable r2 = () -> System.out.println("sb..2");

        r2.run();

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

        System.out.println("********************************");

        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);

        System.out.println(comparator2.compare(1, 2));

        System.out.println("********************************");

        Comparator<Integer> comparator3 = Integer :: compare;

        System.out.println(comparator3.compare(1, 2));



    }

}
