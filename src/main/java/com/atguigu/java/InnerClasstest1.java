/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 03:26
 */

package com.atguigu.java;

public class InnerClassTest1 {

    public void method(){
        class AA{

        }
    }

    public Comparable getComparable(){
        class MyComparable implements Comparable{
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }

        return new MyComparable();
    }

    public Comparable getComparable2(){

        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }

}
