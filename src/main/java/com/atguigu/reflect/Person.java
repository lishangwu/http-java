/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 13:01
 */

package com.atguigu.reflect;

public class Person {

    private String name;
    public int age;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    public Person(String namn, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("你好我是一个人");
    }

    private String say(String str){
        return "草泥马:" + str;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
