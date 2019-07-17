/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 20:01
 */

package com.atguigu.io;

import org.junit.Test;

import java.io.*;

public class PrintStreamTest {

    @Test
    public void test(){

        PrintStream ps = null;

        try {
            FileOutputStream fos = new FileOutputStream(new File("hi1.txt"));

            ps = new PrintStream(fos);
            if(ps != null){
                System.setOut(ps);
            }

            for (int i = 0; i <= 255; i++) {
                System.out.print((char) i);
                if(i % 50 == 0){
                    System.out.println();
                }
            }

            if (fos != null) {
                fos.close();
            }

            if (ps != null) {
                ps.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }

    @Test
    public void test2() {

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("hi1.txt")));
            dos.writeUTF("sb");
            dos.flush();
            dos.writeUTF("sb2");
            dos.flush();
            dos.writeBoolean(false);
            dos.flush();
            dos.writeDouble(1.23);
            dos.flush();

            dos.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test3() {

        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(new File("hi1.txt")));

            //写按什么顺序，读按相同的顺序
            System.out.println(dis.readUTF());
            System.out.println(dis.readUTF());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readDouble());


            dis.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
