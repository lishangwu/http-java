/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/12 02:09
 */

package com.atguigu.java;

public class AnnotationTest {

    public static void main(String[] args){



    }



}

//@Target({Type})
@interface MyAnnotation{

    String value() default "hello";

}

@MyAnnotation(value = "hi")
class User{



}