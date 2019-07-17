/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 03:13
 */

package com.atguigu.java;

public class InnerClassTest {

    public static void main(String[] args){
        
        Person2.Dog d = new Person2.Dog();
        d.wang();

        Person2 p = new Person2();
        Person2.Bird b = p.new Bird();

                
    }

}

class Person2{

    public void eat(){}

    static class Dog{
        String name;

        public Dog() {
        }

        public void wang(){
            System.out.println("wang..");
        }
    }

    class Bird{
        String name;

        public Bird() {
        }

        public void sign(){
            System.out.println("sing..");
            Person2.this.eat();
        }
    }

}

