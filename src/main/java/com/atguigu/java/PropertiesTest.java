/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/13 23:54
 */

package com.atguigu.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PropertiesTest {

    public static void main(String[] args) throws Exception {


//        Properties properties = new Properties();
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        properties.load(fis);
//        System.out.println(properties.getProperty("name"));


        List list = new ArrayList<>();
        list.add(123);
        list.add(312);
        list.add(43);
        list.add(12);
        list.add(4213);

//        Collections.sort(list);

//        List dest = new ArrayList<>();
//        for (int i = 0; i < list.size(); i++) {
//            dest.add(0);
//        }
        List dest = Arrays.asList(new Object[list.size()]);

        Collections.copy(dest, list);

        System.out.println(dest);

        System.out.println(list);

    }

}
