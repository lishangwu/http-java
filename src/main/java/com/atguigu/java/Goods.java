/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/12 01:15
 */

package com.atguigu.java;

//https://www.youtube.com/watch?v=PArFjm04xkg&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=491
public class Goods implements Comparable {

    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {

        if(o instanceof Goods){
            Goods goods = (Goods) o;
            if(this.price > goods.price)
                return 1;
            else if(this.price < goods.price)
                return -1;
            else
                return 0;

//            return Double.compare(this.price, goods.price);

        }


        return 0;
    }

}
