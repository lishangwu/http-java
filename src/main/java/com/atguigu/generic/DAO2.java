/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 01:13
 */

package com.atguigu.generic;

import java.util.*;

public class DAO2<T> {

    private Map<String, T> map = new HashMap<>();

    public void save(String id, T entity){
        map.put(id, entity);
    }

    public T get(String id){

        return map.get(id);
    }

    public void update(String id, T entity){
        if(map.containsKey(id))
            map.put(id, entity);
    }

    public List<T> list(){

        //错误写法
//        Collection<T> values = map.values();//返回的是无序可重复的
//        List<T> list = (List<T>) values;//List是有序可重复的

        List<T> list = new ArrayList<>();
        Collection<T> values = map.values();

        for (T value : values) {
            list.add(value);
        }

        return list;
    }

    public void delete(String id){
        map.remove(id);
    }



}
