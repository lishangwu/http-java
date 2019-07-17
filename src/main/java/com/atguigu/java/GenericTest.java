/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 00:36
 */

package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    //泛型方法
    public <E> List<E> copyFromArrayToList(E[] arr){

        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }

        return list;
    }

}
