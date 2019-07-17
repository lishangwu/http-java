/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 19:25
 */

package com.atguigu.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyInput {

    public static String readString(){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = "";

        try {
            s = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static int readInt(){
        return Integer.parseInt(readString());
    }

    public static double readDouble(){
        return Double.parseDouble(readString());
    }
    public static double readByte(){
            return Byte.parseByte(readString());
        }
    public static double readShort(){
            return Short.parseShort(readString());
        }
    public static double readLong(){
        return Long.parseLong(readString());
    }

}
