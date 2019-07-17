/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 16:31
 */

package com.atguigu.io;

import org.junit.Test;

import java.io.*;
import java.util.*;

public class FileInputOutputStreamTest {

    @Test
    public void test(){

        File f = new File("hi1.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(f);

            //一个中文占三个字节
            //一个字母占一个字节
            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1){
                String s = new String(buf, 0, len);
                System.out.println(s);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void copy(){
        File srcFile = new File("jdbc.properties");
        File destFile = new File("hi1.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //一个中文占三个字节
            //一个字母占一个字节
            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1){
//                String s = new String(buf, 0, len);
//                System.out.println(s);

                fos.write(buf, 0, len);
            }

            System.out.println(new Date(destFile.lastModified()));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("hi1.txt")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("hi2.txt")));

//            char[] chars = new char[1024];
//            int len;
//            while ((len = br.read(chars)) != -1){
//                bw.write(chars, 0, len);
//            }

            // 2
            String data;
            while ( (data = br.readLine()) != null){
                bw.write(data + "\n");
//                bw.newLine();
            }

            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void pwd() throws Exception{
        FileInputStream fis = new FileInputStream(new File("hi1.txt"));
        FileOutputStream fos = new FileOutputStream(new File("hi2.txt"));

        byte[] buf = new byte[1024];
        int len;
        while ( (len = fis.read(buf)) != -1 ){
            for (int i = 0; i < len; i++) {
                buf[i] = (byte) (buf[i] ^ 5);
            }
            fos.write(buf, 0, len);
        }

        fos.close();
        fis.close();
    }

    /**
     *
     * m = 12, n = 5
     *
     * m ^ n ^ n = m
     *
     * */
    @Test
    public void pwd2() throws Exception{
        FileInputStream fis = new FileInputStream(new File("hi2.txt"));
//        FileOutputStream fos = new FileOutputStream(new File("hi2.txt"));

        byte[] buf = new byte[1024];
        int len;
        while ( (len = fis.read(buf)) != -1 ){
            for (int i = 0; i < len; i++) {
                buf[i] = (byte) (buf[i] ^ 5);
            }
            System.out.println(new String(buf, 0, len));
        }

        fis.close();
    }

    @Test
    public void test3() throws Exception{

        Map<Character, Integer> map = new TreeMap<>();
        FileInputStream fis = new FileInputStream(new File("hi1.txt"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            for (int i = 0; i < len; i++) {
                char c = (char) bytes[i];
                if(map.get(c) != null){
                    Integer integer = map.get(c);
                    map.put(c, integer ++);
                }else {
                    map.put(c, 1);
                }
            }
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            System.out.println(next.getKey() + " : " + next.getValue());
        }

        fis.close();

    }

    @Test
    public void test4() throws Exception{

        Map<Character, Integer> map = new TreeMap<>();
        FileReader fr = new FileReader(new File("hi1.txt"));

        int c;
        while ((c = fr.read()) != -1){
            char ch = (char) c;
            if (map.get(ch) == null) {
                map.put(ch, 1);
            }else {
                map.put(ch, map.get(ch) + 1);
            }
        }



        BufferedWriter bw = new BufferedWriter(new FileWriter(new File("hi2.txt")));


        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
//        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<Character, Integer> next = iterator.next();
//            bw.write(next.getKey() + " : " + next.getValue());
//            bw.newLine();
//        }

        for (Map.Entry<Character, Integer> entry : entries) {
            bw.write(entry.getKey() + " : " + entry.getValue());
            bw.newLine();
        }

        bw.close();

        fr.close();


    }

}
