/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 16:55
 */

package com.atguigu.proxy;

interface ClothFactory{
    void product();
}

class ProxyFactory2 implements ClothFactory{

    private ClothFactory factory;

    public ProxyFactory2(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void product() {
        System.out.println("准备..");
        this.factory.product();
        System.out.println("后续..");
    }
}

class NickClothFactory implements ClothFactory{
    @Override
    public void product() {
        System.out.println("生产nick");
    }
}

public class StaticProxyTest {

    public static void main(String[] args){

        ClothFactory clothFactory = new NickClothFactory();

        ClothFactory p = new ProxyFactory2(clothFactory);
        p.product();

    }


}
