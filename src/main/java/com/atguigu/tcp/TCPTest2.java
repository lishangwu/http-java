/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 10:17
 */

package com.atguigu.tcp;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        FileInputStream fis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            socket = new Socket(InetAddress.getByName("localhost"), 9001);
            os = socket.getOutputStream();

            fis = new FileInputStream(new File("hi1.txt"));

            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1){
                os.write(buf, 0, len);
            }
            System.out.println("发送完成");

            socket.shutdownOutput();

            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buf2 = new byte[20];
            int len2;
            while ((len2 = is.read(buf2)) != -1){
                baos.write(buf2, 0, len2);
            }

            String s = baos.toString();
            System.out.println( " from server : " + s);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }

    @Test
    public void Server(){

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        try {
            ss = new ServerSocket(9001);
            socket = ss.accept();
            is = socket.getInputStream();
            fos = new FileOutputStream(new File("hi2.txt"));

            byte[] buf = new byte[20];
            int len;
            while ((len = is.read(buf)) != -1){
                fos.write(buf, 0, len);
            }
            System.out.println("接受完成");

            os = socket.getOutputStream();
            os.write("123".getBytes());
            os.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
