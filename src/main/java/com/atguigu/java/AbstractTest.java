/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 00:36
 */

package com.atguigu.java;

public class AbstractTest {

    public static void main(String[] args){

        Person stu = new Student("sb", 12);
        method(stu);

        System.out.println("*****************************");
        //匿名子类的对象
        Person p = new Person() {
            @Override
            public void eat2() {
                System.out.println("eat2,,");
            }

            @Override
            public void eat3() {
                System.out.println("eat3,,");
            }
        };

        method(p);
        System.out.println("*****************************");

        method(new Person() {
            @Override
            public void eat2() {
                System.out.println("eat2,,");
            }

            @Override
            public void eat3() {
                System.out.println("eat3,,");
            }
        });
                
    }

    public static void method(Person p){
        p.eat();
        p.eat2();
        p.eat3();
    }

}

//抽象类的子类 去实例化
abstract class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void eat(){
        System.out.println("eat..");
    }

    public abstract void eat2();
    public abstract void eat3();

    public void run(){

    }
}

class Student extends Person{
    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat2() {
        System.out.println("eat2 .. Student .. ");
    }

    @Override
    public void eat3() {
        System.out.println("eat3 .. Student .. ");
    }
}
