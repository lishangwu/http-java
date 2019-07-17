/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/12 01:44
 */

package com.atguigu.java;

import java.util.Arrays;

public class Seasontest {

    public static void main(String[] args){
        
           Season.A.getDesc();

        System.out.println();

        SeasonE[] values = SeasonE.values();
        System.out.println(Arrays.toString(values));

    }

}

interface Info{
    void show();
}

enum SeasonE implements Info{
    A("AA", "aa"){
        @Override
        public void show() {

        }
    },
    B("BB", "bb"){
        @Override
        public void show() {

        }
    },
    C("CC", "cc"){
        @Override
        public void show() {

        }
    },
    D("DD", "dd"){
        @Override
        public void show() {

        }
    };

    private final String name;
    private final String desc;

    private SeasonE(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

//    @Override
//    public void show() {
//
//    }
}

class Season{

    private final String name;
    private final String desc;

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public static final Season A = new Season("A", "aa");
    public static final Season B = new Season("B", "bb");
    public static final Season C = new Season("C", "cc");
    public static final Season D = new Season("D", "dd");

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}