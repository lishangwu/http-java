/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 19:10
 */

package com.atguigu.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OtherStream {

    public static void main(String[] args) throws Exception{

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);


        while (true){
            String s = br.readLine();
            if("e".equalsIgnoreCase(s) || s.equalsIgnoreCase("exit")){
                break;
            }

            System.out.println(s.toUpperCase());
        }


        br.close();


    }

    @Test
    public void test() throws Exception{


    }

}
