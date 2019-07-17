/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 01:11
 */

package com.atguigu.java;

public class Manager extends Employee {

    private double bonus;

    public Manager(double bonus) {
        super();
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("Manager work ..");
    }
}
