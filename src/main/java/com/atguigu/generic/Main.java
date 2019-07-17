/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 01:19
 */

package com.atguigu.generic;

public class Main {

    public static void main(String[] args){

        UserDao userDao = new UserDao();

        userDao.save("1001", new User("1001", 1231,"sb1"));
        userDao.save("1002", new User("1002", 1232,"sb2"));
        userDao.save("1003", new User("1003", 1233,"sb3"));

        System.out.println(userDao.list());

        //java8
        userDao.list().forEach(System.out::println);
    }

}
