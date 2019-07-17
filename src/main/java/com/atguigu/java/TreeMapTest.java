/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/13 23:35
 */

package com.atguigu.java;

import org.junit.Test;

import java.util.*;

public class TreeMapTest {
    //key必须是由同一个类创建的对象， 要按照key进行自然排序 或 定制排序

    @Test
    public void test(){
        TreeMap map = new TreeMap();

        map.put(new User1("asd", 12), 12);
        map.put(new User1("xcv", 32), 12);
        map.put(new User1("qwe", 122), 12);
        map.put(new User1("qwe", 32), 12);
        map.put(new User1("qwe", 43), 12);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                if(o1 instanceof User1 && o2 instanceof User1){
                    User1 u1 = (User1) o1;
                    User1 u2 = (User1) o2;
                    return -Integer.compare(u1.getScore(), u2.getScore());
                }

                throw new RuntimeException(" type errrrrrr");
            }
        });

        map.put(new User1("asd", 12), 12);
        map.put(new User1("xcv", 32), 12);
        map.put(new User1("qwe", 122), 12);
        map.put(new User1("qwe", 32), 12);
        map.put(new User1("qwe", 43), 12);

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            Map.Entry entry = (Map.Entry) next;
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}

class User1 implements Comparable{

    private String name;
    private int score;

    public User1(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "User1{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        if(o instanceof User1){
            User1 user = (User1) o;
            int compare = this.name.compareTo(user.name);
            if(compare != 0)
                return compare;
            else
                return Integer.compare(this.score, user.score);
        }else {
            throw new RuntimeException("type err");
        }
    }
}
