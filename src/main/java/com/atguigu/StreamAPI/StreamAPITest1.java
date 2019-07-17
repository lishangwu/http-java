/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 23:45
 */

package com.atguigu.StreamAPI;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class StreamAPITest1 {

    //筛选 切片
    @Test
    public void test(){

        List<User> users = UserData.getUsers();

        //顺序流
        Stream<User> stream = users.stream();

//        stream.filter(new Predicate<User>() {
//            @Override
//            public boolean test(User user) {
//                return user.getId() > 10003;
//            }
//        }).forEach(System.out::println);

        System.out.println("******************************");

        stream.filter(user -> user.getId() > 10004).forEach(System.out::println);

        System.out.println("******************************");

        users.stream().limit(3).forEach(System.out::println);

        System.out.println("******************************");

        users.stream().skip(3).forEach(System.out::println);

        System.out.println("******************************");
        users.stream().distinct().forEach(System.out::println);

        //并行流
//        Stream<User> parallelStream = users.parallelStream();

    }

    //映射
    @Test
    public void test2(){

        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.stream().map(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return s.toUpperCase();
            }
        }).forEach(System.out::println);

        System.out.println("******************************");

        list.stream().map(s -> s.toUpperCase()).forEach(System.out::println);

        System.out.println("******************************");

        //获取姓名长度大于3的名字

        List<User> users = UserData.getUsers();
        Stream<String> nameStream = users.stream().map(user -> user.getName());
        nameStream.filter(s -> s.length() >= 3).forEach(System.out::println);

        System.out.println("******************************");


        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);

        streamStream.forEach(s->{
            s.forEach(System.out::println);
        });

        System.out.println("******************************");

        list.stream().flatMap(StreamAPITest1::fromStringToStream).forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();

        for (Character c : str.toCharArray()) {
            list.add(c);
        }

        return list.stream();

    }

    //排序
    @Test
    public void test3(){

        List<Integer> list = Arrays.asList(23, 3, 21, 23, 453, 5);
        list.stream().sorted().forEach(System.out::println);



    }


}
