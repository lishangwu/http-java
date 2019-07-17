/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 02:47
 */

package com.atguigu.java;

interface A{
    int x = 0;
}

class B{
    int x = 1;
}

public class C extends B implements A {


    public void pX(){
        System.out.println(super.x);
        System.out.println(A.x);
    }

    public static void main(String[] args){
        
        new C().pX();
                
    }


}
