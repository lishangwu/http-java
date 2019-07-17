/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 15:47
 */

package com.atguigu.java1_1;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class OtherTest {

    @Test
    public void test(){

        Class<Person> clazz = Person.class;

        //当前运行时类 的 public 构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        //当前运行时类 的 所有 构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for (Constructor c : declaredConstructors) {
            System.out.println(c);
        }
    }

    //运行时类 的 父类
    @Test
    public void test1(){

        Class<Person> clazz = Person.class;

        Class superclass = clazz.getSuperclass();

    }

    //运行时类 的 带 泛型 的父类
    @Test
    public void test2(){

        Class<Person> clazz = Person.class;

        //运行时类 的 带 泛型 的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);

        //运行时类 的 带 泛型 的父类 的泛型
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);
        System.out.println(actualTypeArguments[0].getTypeName());

    }

    //运行时类 的 实现的接口
    @Test
    public void test3(){

        Class<Person> clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c);
        }

        System.out.println();

        //运行时类 的父类 的 实现的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class<?> c : interfaces1) {
            System.out.println(c);
        }

    }

    //运行时类 所在包
    @Test
    public void test4(){

        Class<Person> clazz = Person.class;

        Package p = clazz.getPackage();
        System.out.println(p.getName());

        System.out.println();

        Package p2 = clazz.getSuperclass().getPackage();
        System.out.println(p2.getName());
    }

    //运行时类 所声明的注解
    @Test
    public void test5(){

        Class<Person> clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
    }

}
