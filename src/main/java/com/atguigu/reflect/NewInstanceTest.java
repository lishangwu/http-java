/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 14:34
 */

package com.atguigu.reflect;

import org.junit.Test;

import java.util.Random;

public class NewInstanceTest {

    @Test
    public void test() throws IllegalAccessException, InstantiationException {

        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();

    }

    @Test
    public void test2(){

        for (int i = 0; i < 10; i++) {
            int num = new Random().nextInt(3);
            System.out.println(num);
            String classPath = "";
            switch (num){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
//                    classPath = "java.sql.Date";//没有空参构造器
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "com.atguigu.reflect.Person";
                    break;
            }
            try {
                Object obj = getInstance(classPath);
                System.out.println(obj);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }

    }

    public Object getInstance(String classPath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
