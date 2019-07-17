/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 14:46
 */

package com.atguigu.java1;

import java.io.Serializable;

public class Creature<T> implements Serializable {


//    private static final long serialVersionUID = -6403346201077474028L;

    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物无锡");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
