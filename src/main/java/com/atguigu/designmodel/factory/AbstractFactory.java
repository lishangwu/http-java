/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 02:38
 */

package com.atguigu.designmodel.factory;

//抽象工厂
public class AbstractFactory {

    public static void main(String[] args){
        
        Car a = new AodiFactory().getCar();
        Car b = new BenchiFactory().getCar();

        a.run();
        b.run();
                
    }

}


interface Factory{
    Car getCar();
}

class AodiFactory implements Factory{

    @Override
    public Aodi getCar() {
        return new Aodi();
    }
}

class BenchiFactory implements Factory{

    @Override
    public Benchi getCar() {
        return new Benchi();
    }
}