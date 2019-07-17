/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/16 11:07
 */

package com.atguigu.Optional;

public class Girl {

    private String name;

    public Girl() {
    }

    public Girl(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }
}
