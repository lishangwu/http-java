/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/12 12:39
 */

package com.atguigu.java;

public class CC implements Comparable {

    private String name;
    private String pwd;

    public CC(String name, String pwd) {
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
    public int compareTo(Object o) {

        if(o instanceof CC){
            CC c = (CC) o;
            return this.name.compareTo(c.name);
        }

//        return 0;
        throw new RuntimeException("不能传人相同数据");
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
