/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 20:18
 */

package com.atguigu.io;

import org.junit.Test;

import java.io.*;

public class ObjectInputOutputStreamTest {

    @Test
    public void test(){

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));

            oos.writeObject(new String("飞雪连天射白鹿"));
            oos.flush();

            oos.writeObject(new Person("sb", "asd"));
            oos.flush();

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }


    }

    @Test
    public void test2(){

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));

            Object o = ois.readObject();
            System.out.println(o);
            Person p = (Person) ois.readObject();
            System.out.println(p);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }

}

