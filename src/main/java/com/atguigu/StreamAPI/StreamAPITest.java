/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 23:45
 */

package com.atguigu.StreamAPI;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPITest {

    //创建stream 通过集合
    @Test
    public void test(){

        List<User> users = UserData.getUsers();

        //顺序流
        Stream<User> stream = users.stream();

        //并行流
        Stream<User> parallelStream = users.parallelStream();

    }

    //通过数组
    @Test
    public void test2(){

        int[] arr = new int[]{1,2,3,4,5};

        IntStream stream = Arrays.stream(arr);

        User u1 = new User(1001, "Tom", 123123);
        User u2 = new User(1002, "Tom2", 123123);

        User[] arr2 = new User[]{u1, u2};
        Stream<User> stream1 = Arrays.stream(arr2);

    }

    @Test
    public void test3(){

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);

    }

    @Test
    public void test4(){


        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }

}
