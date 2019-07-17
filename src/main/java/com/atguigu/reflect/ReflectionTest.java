/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 13:01
 */

package com.atguigu.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void test(){

        Person p1 = new Person("Tom", 12);

        p1.age = 10;

        System.out.println(p1);
//        p1.say();

    }

    @Test
    public void test2() throws Exception {


        Class clazz = Person.class;
        Constructor cons = clazz.getConstructor(String.class, int.class);


        Person p = (Person) cons.newInstance("Tom", 12);

        System.out.println(p);

        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);

        System.out.println(p);

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        //private
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person jerry = (Person) cons1.newInstance("Jerry");

        System.out.println(jerry);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jerry, "Hanmeimei");

        System.out.println(jerry);

        Method say = clazz.getDeclaredMethod("say", String.class);
        say.setAccessible(true);
        String sb = (String) say.invoke(jerry, "sb");
        System.out.println(sb);

    }

    @Test
    public void test3() throws Exception {



        //1
        Class<Person> clazz = Person.class;
        System.out.println(clazz);

        //2
        Person person = new Person();
        Class clazz2 = person.getClass();

        //3
        Class clazz3 = Class.forName("com.atguigu.reflect.Person");

        System.out.println(clazz == clazz2);
        System.out.println(clazz2 == clazz3);

        //4
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.atguigu.reflect.Person");

        System.out.println(clazz2 == clazz4);

    }

}
