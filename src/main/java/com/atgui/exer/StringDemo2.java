/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/11 23:45
 */

package com.atgui.exer;

public class StringDemo2 {

//    一个字符串在另一个中出现的次数

    public int getCount(String mainStr, String subStr){

        int mainLength = mainStr.length();
        int subLength = subStr.length();
        if(mainLength < subLength)
            return 0;

        int count = 0;
        int index = 0;
//        while ( (index = mainStr.indexOf(subStr)) != -1 ){
//            count ++;
//            mainStr = mainStr.substring(index + subStr.length());
//        }

        while ( (index = mainStr.indexOf(subStr, index)) != -1 ){
            count ++;
            index += subLength;
        }

        return count;

    }

    public static void main(String[] args){

        StringDemo2 sd = new StringDemo2();

//        System.out.println(sd.reverse2("abcdefg", 2, 5));

        System.out.println(sd.getCount("abababababaasdasdbaab", "ab"));

    }

}
