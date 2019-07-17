/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 02:36
 */

package com.atguigu.designmodel.factory;

//简单工厂
public class EasyFactory {

    public static Car getCar(String type){
        if("Aodi".equals(type)){
            return new Aodi();
        }

        if("Benchi".equals(type)){
            return new Benchi();
        }

        return null;
    }


}
