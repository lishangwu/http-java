/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/13 13:03
 */

package com.atguigu.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class HashCodeTest {

    @Test
    public void test(){

        System.out.println("abc".hashCode());

        double a = 3.1415926;
        System.out.println(((Double) a).hashCode());

        CCC c = new CCC("sb", "sbb", 12);
        System.out.println(c.hashCode());

        HashSet<CCC> hashSet = new HashSet<>();
        hashSet.add(c);

        System.out.println(Arrays.toString(hashSet.toArray()));

        HashMap<CCC, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 123);

        Hashtable<CCC, Integer> hashtable = new Hashtable<>();
//        hashtable.put(null,null);

//        System.out.println(c instanceof Testt);

        Object[] arr = new Object[10];
        arr[1] = "asd";
        arr[2] = new Integer(123);
        arr[3] = c;

        System.out.println(Arrays.toString(arr));

        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("java.version"));

    }

}

interface Testt{}

class CCC implements Testt{
    private String name;
    private String pwd;
    private int age;

    public CCC(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    @Override
    public String toString() {
        return "CCC{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }

    //    @Override
//    public int hashCode() {
//        int B = 31;
//        int hash = 0;
//        hash = hash * B + name.hashCode();
//        hash = hash * B + pwd.hashCode();
//        hash = hash * B + age;
//        return hash;
//    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CCC ccc = (CCC) o;
//        return age == ccc.age &&
//                Objects.equals(name, ccc.name) &&
//                Objects.equals(pwd, ccc.pwd);
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name, pwd, age);
//    }
}
