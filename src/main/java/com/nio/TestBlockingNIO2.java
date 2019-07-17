/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 14:23
 */

package com.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * 1: 适用NIO 完成网络通信的三个核心
 *
 * 1。Channel： 负责连接
 *      java.nio.channels.Channel 接口
 *          SelectableChannel
 *              socketChannel
 *              ServerSocketChannel
 *              DatagramChannel
 *
 *              Pipe.SinkChannel
 *              Pipe.SourceChannel
 *
 * 2。Buffer： 负责数据的存取
 * 3。Selector： 是SelectableChannel 的多路复用器， 用于监控是SelectableChannel 的IO 状况
 *
 *
 * @return
 * */

public class TestBlockingNIO2 {

    @Test
    public void client() throws IOException {

        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9001));

        FileChannel fileChannel = FileChannel.open(Paths.get("hi1.txt"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while ((fileChannel.read(buf)) != -1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        sChannel.shutdownOutput();

        int len;
        while ((len = sChannel.read(buf)) != -1){
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }

        fileChannel.close();
        sChannel.close();

    }

    @Test
    public void Server() throws IOException {

        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel fileChannel = FileChannel.open(Paths.get("hi2.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        ssChannel.bind(new InetSocketAddress(9001));

        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while ((sChannel.read(buf)) != -1){
            buf.flip();
            fileChannel.write(buf);
            buf.clear();
        }

        buf.put("接受完成。。".getBytes());
        buf.flip();
        sChannel.write(buf);


        fileChannel.close();
        sChannel.close();
        ssChannel.close();

    }

}
