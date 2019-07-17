/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 14:59
 */

package com.atguigu.java1_1;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {


    @Test
    public void test(){

        Class<Person> clazz = Person.class;

        //getFields 获取当前运行时类 及其 父类 的public属性
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        space();

        //获取当前运行时类 自己的所有属性，，不包含父类的属性
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

    }

    //权限修饰符， 数据类型， 变量名(public int id;)
    @Test
    public void test2(){

        Class<Person> clazz = Person.class;

        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field f : declaredFields) {
            //            权限修饰符
            int modifiers = f.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");

            //            数据类型
            Class type = f.getType();
            System.out.print(type.getName() + "\t");

            //            数据类型
            String name = f.getName();
            System.out.println(name + "\t");

        }

    }

    public static void space(){
        System.out.println();
        System.out.println("******************************");
        System.out.println();
    }

}
