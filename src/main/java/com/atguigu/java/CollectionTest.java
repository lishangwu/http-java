/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/12 10:43
 */

package com.atguigu.java;

import org.junit.Test;

import java.util.*;

public class CollectionTest {

    @Test
    public void test1(){

        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(23);
        coll.add(new SS("asd","asd"));

        Collection coll1 = Arrays.asList(123,23,12312);

        coll.retainAll(coll1);

        System.out.println(coll);


    }

}


class SS{
    private String name;
    private String pwd;

    public SS(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        SS ss = (SS) o;
//
//        if (name != null ? !name.equals(ss.name) : ss.name != null) return false;
//        return pwd != null ? pwd.equals(ss.pwd) : ss.pwd == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
//        return result;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SS ss = (SS) o;
        return Objects.equals(name, ss.name) &&
                Objects.equals(pwd, ss.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pwd);
    }
}