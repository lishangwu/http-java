/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 14:46
 */

package com.atguigu.java1;

@MyAnnptation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {


    private String name;
    int age;
    public int id;

    public Person() {
    }

    @MyAnnptation(value = "abc")
    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnptation
    private String show(String nation){
        System.out.println("我的国际是" + nation);
        return nation;
    }

    private String display(String interests, int age) throws NullPointerException, ClassCastException{
        return interests;
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    private static void showDesc(){
        System.out.println("showDesc...");
    }
}
