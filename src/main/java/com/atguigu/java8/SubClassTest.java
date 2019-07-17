/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 03:03
 */

package com.atguigu.java8;

public class SubClassTest {

    public static void main(String[] args){
        
        SubClass s = new SubClass();

        s.method2();

        CompareA.method1();
                
    }

}

class SubClass implements CompareA{

}
