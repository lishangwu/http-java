/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 23:13
 */

package com.atguigu.Lambda;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 方法引用
 *
 * */
public class MethodRefTest {

    @Test
    public void test(){

        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("sb..");

        Consumer<String> con2 = System.out::println;
        con2.accept("sb..2");

    }

    @Test
    public void test2(){

        Emp emp = new Emp("Tom", "sb");

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "sb";
            }
        };

        supplier = () -> emp.getName();
        supplier = emp::getName;

        System.out.println(supplier.get());

    }

}

class Emp{
    private String name;
    private String pwd;

    public Emp(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}