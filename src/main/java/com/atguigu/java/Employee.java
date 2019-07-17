/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 01:09
 */

package com.atguigu.java;

abstract public class Employee {

    private String name;
    private int id;
    private double salary;

    public Employee() {
    }

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public abstract void work();
}

