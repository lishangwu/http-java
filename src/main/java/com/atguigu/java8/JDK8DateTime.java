/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/12 00:55
 */

package com.atguigu.java8;

import java.time.LocalDate;
import java.time.LocalTime;

public class JDK8DateTime {

    public static void main(String[] args){

        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        System.out.println(now);
        System.out.println(now1);

    }

}
