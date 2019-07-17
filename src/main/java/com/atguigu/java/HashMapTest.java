/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/13 23:22
 */

package com.atguigu.java;

import org.junit.Test;

import java.util.*;

public class HashMapTest {

    @Test
    public void test(){
        HashMap map = new HashMap();

        map.put(1,"AA");
        map.put(2,"asd");
        map.put(3,"we");

        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        System.out.println();

        Collection values = map.values();
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println();


        Set set1 = map.entrySet();
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            Map.Entry entry = (Map.Entry) iterator2.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }

    @Test
    public void test2(){
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1,"AA");
        map.put(2,"asd");
        map.put(3,"we");

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, String> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }
    }

}
