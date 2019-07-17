/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 20:23
 */

package com.atguigu.io;

import java.io.Serializable;

//标识接口
public class Person implements Serializable{


    private static final long serialVersionUID = 4763461785435723412L;
    private String name;
    private String pwd;

    public Person(String name, String pwd) {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
