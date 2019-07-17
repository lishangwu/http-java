/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 16:09
 */

package com.atguigu.java1_1;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest {

    @Test
    public void test() throws Exception {

        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();

        Field id = clazz.getField("id");

        id.set(p, 1001);
        int pId = (int) id.get(p);
        System.out.println(pId);

    }

    @Test
    public void test2() throws Exception {

        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p, "Tom");

        System.out.println(name.get(p));

    }

    @Test
    public void test3() throws Exception {

        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();

        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        String tom = (String) show.invoke(p, "Tom");
        System.out.println(tom);

        System.out.println("-------------静态方法调用");

        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object invoke = showDesc.invoke(Person.class);
        System.out.println(invoke);
    }

    @Test
    public void test4() throws Exception {

        Class<Person> clazz = Person.class;
        Constructor<Person> declaredConstructor = clazz.getDeclaredConstructor(String.class);

        declaredConstructor.setAccessible(true);
        Person tom = declaredConstructor.newInstance("Tom");


    }

}
