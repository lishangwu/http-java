/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 23:45
 */

package com.atgui.exer;

public class StringDemo {

//    字符串部分反转

    public String reverse(String str, int startIndex, int endIndex){

        if(str == null || str.length() == 0)
            return null;

        char[] chars = str.toCharArray();
        for (int x = startIndex, y = endIndex; x < y; x++, y--){
            char temp = chars[x];
            chars[x] = chars[y];
            chars[y] = temp;
        }

        return new String(chars);
    }

    public String reverse1(String str, int startIndex, int endIndex){

        if(str == null || str.length() == 0)
            return null;

        String reverseStr = str.substring(0, startIndex);

        for (int i = endIndex; i>= startIndex; i--){
            reverseStr += str.charAt(i);
        }

        reverseStr += str.substring(endIndex + 1);

        return reverseStr;
    }

    public String reverse2(String str, int startIndex, int endIndex){

        if(str == null || str.length() == 0)
            return null;

        StringBuilder sb = new StringBuilder(str.length());
        sb.append(str.substring(0, startIndex));
        for (int i = endIndex; i>=startIndex; i--){
            sb.append(str.charAt(i));
        }
        sb.append(str.substring(endIndex + 1));

        return sb.toString();

    }
    
    public static void main(String[] args){

        StringDemo sd = new StringDemo();

        System.out.println(sd.reverse2("abcdefg", 2, 5));

    }

}
