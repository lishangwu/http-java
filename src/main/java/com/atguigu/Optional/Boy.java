/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/16 11:08
 */

package com.atguigu.Optional;

public class Boy {

    private Girl girl;


    public Boy() {
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }
}
