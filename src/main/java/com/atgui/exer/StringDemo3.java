/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 23:45
 */

package com.atgui.exer;

public class StringDemo3 {

//    获取两个字符串 最大相同子串
//    https://www.youtube.com/watch?v=IFbRgxK827A&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=475

    public String getMaxSameString(String str1, String str2){


        String maxStr = str1.length() >= str2.length() ? str1 : str2;
        String minStr = str1.length() < str2.length() ? str1 : str2;

        int length = minStr.length();

        for (int i = 0; i < length; i++) {
            for (int x=0, y=length-i; y<=length; x++,y++){
                String subStr = minStr.substring(x, y);
                if(maxStr.contains(subStr))
                    return minStr;
            }
        }

        return null;

    }

    public static void main(String[] args){

        StringDemo3 sd = new StringDemo3();

//        System.out.println(sd.reverse2("abcdefg", 2, 5));

        System.out.println(sd.getMaxSameString("abababababaasdasdbaab", "asd"));

    }

}
