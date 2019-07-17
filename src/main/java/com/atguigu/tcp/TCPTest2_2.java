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

public class TCPTest2_2 {

    @Test
    public void client() throws Exception {

        Socket socket = new Socket(InetAddress.getByName("localhost"), 9001);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("hi1.txt");

        byte[] buf = new byte[1024];
        int len;
        while((len = fis.read(buf)) != -1){
            os.write(buf, 0, len);
        }

        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buf2 = new byte[1024];
        int len2;
        while ((len2 = is.read(buf2)) != -1){
            baos.write(buf2, 0, len2);
        }
        System.out.println("from server : " + baos.toString());

        is.close();
        fis.close();
        os.close();
        socket.close();
        baos.close();



    }

    @Test
    public void Server() throws IOException {

        ServerSocket ss = new ServerSocket(9001);
        Socket socket = ss.accept();
        InputStream is = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream("hi3.txt");
        byte[] buf = new byte[1024];
        int len;
        while ((len = is.read(buf)) != -1){
            fos.write(buf, 0, len);
        }

        System.out.println("receive over ..");

        OutputStream os = socket.getOutputStream();
        os.write("hello world傻逼".getBytes());

        fos.close();
        is.close();
        socket.close();
        ss.close();
        os.close();



    }

}
