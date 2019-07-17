/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 17:47
 */

package com.atguigu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Human{

    String getBelief();

    void eat(String food);

}

class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃" + food);
    }
}

class humanUtil{

    public void method1(){
        System.out.println("=================================通用方法 1 =================================");
    }

    public void method2(){
        System.out.println("=================================通用方法 2 =================================");
    }

}


/**
 * 动态代理
 *https://www.youtube.com/watch?v=_iMUk-LYNWE&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=654
 * 1.如何根据加载到内存中的被代理类， 动态创建一个代理类及其对象
 * 2.通过代理类的对象调用方法的时候， 如何动态的去调用被代理类中的同名方法
 * */


class ProxyFactory{

    //根据传进的 被代理对象， 动态创建"被代理对象"
    public static Object getProxyIntance(Object obj){

        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);

    }

}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }

    //当 通过 代理类的对象 调用方法a时， 就会自动调用如下方法invoke
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        humanUtil humanUtil = new humanUtil();
        humanUtil.method1();

        Object returnValue = method.invoke(obj, args);

        humanUtil.method2();

        return returnValue;
    }
}


public class ProxyTest {

    public static void main(String[] args){

        SuperMan superMan = new SuperMan();

        //出来的类 实现了Human接口
        Human proxyIntance = (Human) ProxyFactory.getProxyIntance(superMan);

        String str = proxyIntance.getBelief();
        proxyIntance.eat("苹果");

        System.out.println();

        NickClothFactory nickClothFactory = new NickClothFactory();
        ClothFactory proxyIntance1 = (ClothFactory) ProxyFactory.getProxyIntance(nickClothFactory);

        proxyIntance1.product();
    }

}
