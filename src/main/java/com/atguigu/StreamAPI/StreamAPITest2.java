/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 23:45
 */

package com.atguigu.StreamAPI;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest2 {

    //匹配 查找
    @Test
    public void test(){

        List<User> users = UserData.getUsers();

        users.stream().forEach(System.out::println);

        System.out.println("******************************1");

        boolean b = users.stream().allMatch(user -> user.getId() > 10003);
        System.out.println(b);

        System.out.println("******************************2");

        b = users.stream().anyMatch(user -> user.getId() > 10003);
        System.out.println(b);

        System.out.println("******************************3");

        //有-》返回false
        b = users.stream().noneMatch(user -> user.getName().startsWith("AA"));
        System.out.println(b);

        System.out.println("******************************4");

        Optional<User> first = users.stream().findFirst();
        System.out.println(first);

        System.out.println("******************************5");

        Optional<User> any = users.stream().findAny();
        System.out.println(any.get());

        System.out.println("******************************6");


        System.out.println(users.stream().max(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getId() - o2.getId();
            }
        }).get());

        Optional<User> max = users.stream().max((o1, o2) -> o1.getId() - o2.getId());

        System.out.println(max.get());

        System.out.println("******************************");

        Optional<User> min = users.stream().min((o1, o2) -> o1.getId() - o2.getId());
        System.out.println(min.get());
        System.out.println("******************************");

    }

    @Test
    public void test2(){

        List<User> users = UserData.getUsers();
        users.stream().forEach(System.out::println);//stream终止操作

        System.out.println("******************************1");

        long count = users.stream().filter(user -> user.getId() > 10003).count();
        System.out.println(count);

        System.out.println("******************************");

        Stream<Integer> integerStream = users.stream().map(user -> user.getId());
        Optional<Integer> max = integerStream.max(Integer::compare);
        System.out.println(max.get());

        System.out.println("******************************");

        Optional<User> min = users.stream().min((u1, u2) -> Double.compare(u1.getId(), u2.getId()));


        System.out.println("******************************");


    }

    //规约
    @Test
    public void test3(){


        List<User> users = UserData.getUsers();
        users.stream().forEach(System.out::println);//stream终止操作

        System.out.println("******************************1");

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        System.out.println("******************************");

        Stream<Double> doubleStream = users.stream().map(user -> user.getSalary());
        Stream<Double> doubleStream1 = users.stream().map(User::getSalary);

//        System.out.println(doubleStream.reduce(Double::sum));
        System.out.println(doubleStream.reduce((d1, d2) -> d1 + d2));

        System.out.println("******************************");




    }

    //收集
    @Test
    public void test4(){

        List<User> users = UserData.getUsers();
        users.stream().forEach(System.out::println);//stream终止操作

        System.out.println("******************************list");

        List<User> list = users.stream().filter(user -> user.getId() > 10003).collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("******************************set");

        Set<User> set = users.stream().filter(user -> user.getId() > 10003).collect(Collectors.toSet());
        set.forEach(System.out::println);
        System.out.println("******************************");


    }



}
