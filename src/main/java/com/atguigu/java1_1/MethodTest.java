/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 15:13
 */

package com.atguigu.java1_1;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MethodTest {

    @Test
    public void test(){

        Class<Person> clazz = Person.class;

        //getMethods 获取当前运行时类 及其 父类 声明为public方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println();

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

    }

    //权限修饰符， 返回值类型， 方法名（参数类型1 型参1 .. ）throw XxxException{}
    @Test
    public void test2(){

        Class<Person> clazz = Person.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {


            //获取注解
            Annotation[] annotations = m.getAnnotations();
            for (Annotation a : annotations) {
                System.out.print(a);
            }

            //权限修饰符
            System.out.print(Modifier.toString(m.getModifiers()) + "\t");

            //返回值类型
            System.out.print(m.getReturnType().getName() + "\t");

            //方法名
            System.out.print(m.getName() + "\t");
            System.out.print("(");
            //型参列表

            Class[] parameterTypes = m.getParameterTypes();
            if (parameterTypes != null && parameterTypes.length != 0) {
                for (int i=0; i<parameterTypes.length; i++) {
                    if(i == parameterTypes.length - 1){
                        System.out.print(parameterTypes[i].getName() + " args_" + i);
                        break;
                    }
                    System.out.print(parameterTypes[i].getName() + " args_" + i + ",");
                }
            }

            //抛出异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (exceptionTypes != null && exceptionTypes.length > 0) {
                System.out.println(" throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    if(i == exceptionTypes.length - 1){
                        System.out.print(exceptionTypes[i].getName());
                        break;
                    }
                    System.out.print(exceptionTypes[i].getName() + ",");
                }
            }

            System.out.print(")");
            System.out.println();
        }


    }

}
