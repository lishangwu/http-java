/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/16 11:07
 */

package com.atguigu.Optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test(){


        Girl girl = new Girl();

        Optional<Girl> girlOptional = Optional.of(girl);

    }

    @Test
    public void test2(){


        Girl girl = new Girl();

        Optional<Girl> girlOptional = Optional.ofNullable(null);
        System.out.println(girlOptional);

    }

    public String getGirlname(Boy boy){
        return boy.getGirl().getName();
    }

    public String getGirlname1(Boy boy){
        if (boy == null) {
            return null;
        }
        Girl girl = boy.getGirl();
        if (girl == null) {
            return null;
        }

        return girl.getName();

    }

    public String getGirlname2(Boy boy){
        Optional<Boy> boyOptional = Optional.ofNullable(boy);
        Boy boy1 = boyOptional.orElse(new Boy(new Girl("迪丽热巴")));

        Girl girl = boy1.getGirl();
        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("刘亦菲"));

        return girl1.getName();

    }

    @Test
    public void test3(){

        Boy boy = new Boy();
        String girlname = getGirlname2(boy);
        System.out.println(girlname);
    }

}
