/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 15:16
 */

package com.nio;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

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

public class TestNonBlockingNIO {

    @Test
    public void clent() throws Exception {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        //切换成 非阻塞模式
        sChannel.configureBlocking(false);

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            String str =  scanner.next();
//
//            ByteBuffer buf = ByteBuffer.allocate(1024);
//            buf.put((new Date().toString() + "\n" + str).getBytes());
//            buf.flip();
//            sChannel.write(buf);
//            buf.clear();
//        }

        while (true){
            Thread.sleep(1000);
            ByteBuffer buf = ByteBuffer.allocate(1024);
            buf.put(new Date().toString().getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

//        ByteBuffer buf = ByteBuffer.allocate(1024);
//        buf.put(new Date().toString().getBytes());
//        buf.flip();
//        sChannel.write(buf);
//        buf.clear();

//        sChannel.close();
    }

    @Test
    public void server() throws IOException {
        //1
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2
        ssChannel.configureBlocking(false);
        //3
        ssChannel.bind(new InetSocketAddress(9898));

        //4.选择器
        Selector selector = Selector.open();
        //5.通道注册到选择器上, 并指定"监听接收事件"
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //6.轮询 获取 选择器上 已经"准备就绪"的事件
        while (selector.select() > 0){

            //7.获取当前选择器中所有注册的"选择键"， （已经就绪的监听事件）
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //8 获取准备"就绪"的事件
                SelectionKey sk = iterator.next();

                //9.判断 具体是什么事件 准备就绪
                if (sk.isAcceptable()) {
                    //10. 若"接受就绪" 获取客户端连接
                    SocketChannel sChannel = ssChannel.accept();
                    //11.切换非阻塞模式
                    sChannel.configureBlocking(false);
                    //12. 该通道注册到选择器上
                    sChannel.register(selector, SelectionKey.OP_READ);
                }else if(sk.isReadable()){
                    //13. 获取当前选择器上"读就绪状态" 的通道
                    SocketChannel sChannel = (SocketChannel) sk.channel();

                    //14.读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len;
                    while ((len = sChannel.read(buf)) > 0){
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }

                }
                //15.取消选择键SelectionKey
                iterator.remove();
            }



        }
    }

}
