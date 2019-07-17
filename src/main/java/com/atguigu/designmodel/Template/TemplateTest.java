/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 01:32
 */

package com.atguigu.designmodel.Template;

//模板方法的设计模式及应用场景
public class TemplateTest {

    public static void main(String[] args){
        
        SubTemplate sub = new SubTemplate();
        sub.spendTime();
                
    }


}

abstract class Template{
    public void spendTime(){
        long start = System.currentTimeMillis();

        //不确定部分
        this.code();

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    public abstract void code();
}


class SubTemplate extends Template{

    @Override
    public void code() {
        for (int i = 2; i < 1000; i++) {
            boolean isFlag = true;
            for (int j = 2; j < Math.sqrt(i); j++) {
                if( i % j == 0){
                    isFlag = false;
                    break;
                }
            }
            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}