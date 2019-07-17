/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 21:41
 */

package com.atguigu.Lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest2 {

    @Test
    public void test(){

        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println(aDouble);
            }
        });

        happyTime(500, (aDouble) -> System.out.println(aDouble));

    }

    public void happyTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test2(){

        ArrayList<String> strings = new ArrayList<>();
        strings.add("asd");
        strings.add("ASD");
        strings.add("QWE");
        strings.add("asasdasd");

        List<String> list = null;
        list = filterString(strings, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.endsWith("d");
            }
        });

        list = filterString(strings, s -> s.endsWith("E"));

        list.forEach(System.out::println);

    }

    public ArrayList<String> filterString(List<String> list, Predicate<String> pre){

        ArrayList<String> filterList = new ArrayList<>();

        for (String s : list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }

        return filterList;


    }


}
