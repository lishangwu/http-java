/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 15:46
 */

package com.atguigu.io;

import org.junit.Test;

import java.io.*;
import java.util.Date;

public class FileReaderWriterTest {

    @Test
    public void test(){
        File file = new File(".gitignore");
        FileReader fr = null;
        try {
            fr = new FileReader(file);

//            int data = fileReader.read();
//            while (data != -1){
//                System.out.print((char)data);
//                data = fileReader.read();
//            }

            int data;
            while ((data = fr.read()) != -1){
                System.out.print((char)data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2(){
        File file = new File("jdbc.properties");
        FileReader fr = null;
        try {
            fr = new FileReader(file);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1){
                //err
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }

                //ok
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }

                //ok2
                String str = new String(cbuf, 0, len);
                System.out.print(str);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test3(){

        File file = new File("hi1.txt");

        FileWriter fw = null;

        try {
            fw = new FileWriter(file,true); //追加
            fw.write("are you sb..\n");
            fw.write("hello ..");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fw != null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    @Test
    public void copy(){

        File srcFile = new File("jdbc.properties");
        File destFile = new File("hi1.txt");

        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            fw.write(new Date().toString() + "\n");

            int len;
            char[] chars = new char[5];
            while ((len = fr.read(chars)) != -1){
//                String str = new String(chars, 0, len);
//                System.out.print(str);
                fw.write(chars, 0, len);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
