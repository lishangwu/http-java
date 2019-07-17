/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 12:35
 */

package com.atguigu.udp;

import org.junit.Test;

import java.net.*;

public class UDPTest {

    @Test
    public void send() throws Exception {

        DatagramSocket socket = new DatagramSocket();


        String str = "upd 测试";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();

        DatagramPacket packet = new DatagramPacket(data, 0, data.length, inet, 9090);

        socket.send(packet);

        socket.close();

    }

    @Test
    public void receiver() throws Exception{

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];

        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

    }

}
