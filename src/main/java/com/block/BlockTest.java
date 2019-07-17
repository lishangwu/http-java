/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/10 18:31
 */

package com.block;

//代码块
public class BlockTest {

    public static void main(String[] args){
        
        new Person().eat();
                
    }

}


class Person{
    String name;
    int age;
    static String desc = "sb..";

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //代码块, 初始化类 或对象
    {
        System.out.println("sb.....1");
    }

    static {
        System.out.println("sb.....static");
    }

    public void eat(){
        System.out.println("eat..");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}