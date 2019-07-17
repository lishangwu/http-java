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
import java.util.Date;

public class TCPTest {

    @Test
    public void client(){

        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            InetAddress localhost = InetAddress.getByName("localhost");
            socket = new Socket(localhost, 8899);
            os = socket.getOutputStream();
            is = socket.getInputStream();

            String msg = "client send : " + new Date().getSeconds() + " : " + "are you sb..";
            os.write(msg.getBytes());



        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void Server(){

        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        ByteArrayOutputStream baos = null;
        try {
            ss = new ServerSocket(8899);
            while (true){
                socket = ss.accept();
                is = socket.getInputStream();
                os = socket.getOutputStream();

                baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int len;
                while ((len = is.read(buf)) != -1){
                    baos.write(buf, 0, len);
//                    String s = new String(buf, 0, len);
//                    String res = "server receive : " + s;
//                    System.out.println(res);
                }

                String msg = baos.toString();
                String s = socket.getInetAddress().getHostAddress() + " ~ " + msg;
                System.out.println(s);

//                String msg = "server send : " + new Date().getSeconds() + " : " + "cao ni ma..";
//                os.write(msg.getBytes());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
