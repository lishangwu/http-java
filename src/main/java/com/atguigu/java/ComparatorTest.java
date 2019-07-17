/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/12 01:25
 */

package com.atguigu.java;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

    public static void main(String[] args){
        
        String[] arr = new String[]{"BB", "DD", "WW", "FF", "BB"};

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return -o1.compareTo(o2);
            }
        });

        System.out.println(Arrays.toString(arr));

    }


}
