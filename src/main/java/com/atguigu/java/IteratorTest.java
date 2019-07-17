/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/12 11:22
 */

package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {


    @Test
    public void test1(){

        Collection coll = new ArrayList();

        coll.add(123);
        coll.add(23);
        coll.add(new SS("asd","asd"));
        coll.add("asd");

        Iterator iterator = coll.iterator();

//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        System.out.println();

//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//        }

//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        while (iterator.hasNext()){
            Object next = iterator.next();
            if("asd".equals(next)){
                iterator.remove();
            }
        }

        iterator = coll.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }




    }

}
