/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 16:40
 */

package com.atguigu.java2;

import java.util.Arrays;

public class StringTest {

    String str = new String("good");
    char[] ch = {'a', 'b', 'c', 'd'};

    //值传递
    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }


    public static void main(String[] args){
        
        StringTest st = new StringTest();

        st.change(st.str, st.ch);

        System.out.println(st.str); // good
        System.out.println(st.ch); //bbcd

        String str1 = "asd";
        char[] chars = str1.toCharArray();
        byte[] bytes = str1.getBytes(); //字节 ASCII码
        System.out.println(Arrays.toString(bytes));


    }
    
}
