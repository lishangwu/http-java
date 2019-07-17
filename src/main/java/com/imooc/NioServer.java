/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 17:22
 */

package com.imooc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NioServer {


    public void start() throws IOException {
        /**
         * 1.创建Selector
         * */
        Selector selector = Selector.open();

        /**
         * 2.ServerSocketChannel 创建channel通道
         * */
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        /**
         * 3.channel绑定监听端口
         * */
        serverSocketChannel.bind(new InetSocketAddress(9001));

        /**
         * 4.设置channel为非阻塞模式
         * */
        serverSocketChannel.configureBlocking(false);

        /**
         * 5.channel注册到selector上， 监听连接事件
         * */
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);//接收连接
        System.out.println("服务器启动成功!");

        /**
         * 6.循环等待新接入的连接
         * */
        for(;;){
            //阻塞式方法
            int readyChannels = selector.select();
            // TODO:
            if(readyChannels == 0) continue;

            //获取可用channel集合
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                //移除Set中当前selectionKey
                iterator.remove();

                /**
                 * 7.根据就绪状态，调用对应方法处理了业务逻辑
                 * */

                /**
                 * 接入事件
                 * */
                if (selectionKey.isAcceptable()) {
                    acceptHandler(serverSocketChannel, selector);
                }

                /**
                 * 可读事件
                 * */
                if (selectionKey.isReadable()) {
                    readHandler(selectionKey, selector);
                }
            }

        }
    }

    private void acceptHandler(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        /**
         * 创建socketChannel
         * */
        SocketChannel socketChannel = serverSocketChannel.accept();

        /**
         * socketChannel --> 非阻塞
         * */
        socketChannel.configureBlocking(false);
        /**
         * channel注册到selector上， 监听可读事件
         * */
        socketChannel.register(selector, SelectionKey.OP_READ);
        /**
         * 回复客户端
         * */
//        Charset charset = Charset.forName("UTF-8");
//        CharsetEncoder charsetEncoder = charset.newEncoder();
//        String str = "你与聊天室其他人都不是好友关系";
//        CharBuffer buf = CharBuffer.allocate(1024);
//        buf.put(str);
//        buf.flip();
//        ByteBuffer encode = charsetEncoder.encode(buf);
//        socketChannel.write(encode);

        socketChannel.write(Charset.forName("UTF-8").encode("你与聊天室其他人都不是好友关系，请注意隐私安全!"));
    }

    private void readHandler(SelectionKey selectionKey, Selector selector) throws IOException {

        /**
         * selectionKey 中 获取已经就绪的channel
         * */
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();

        /**
         * 创建buffer
         * */
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        /**
         * 循环读取客户端请求信息
         * */
        String request = "";
//        byteBuffer.flip();
        while ((socketChannel.read(byteBuffer)) > 0){
            byteBuffer.flip();
            request += Charset.forName("UTF-8").decode(byteBuffer);
        }

        /**
         * 将channel再次注册到selector上，监听他的可读事件
         * */
        socketChannel.register(selector, SelectionKey.OP_READ);


        /**
         * 将客户端发送的请求信息 广播给其他客户端
         * */
        if (request.length() > 0) {
            System.out.println(":: " + request);
            broadCast(selector, socketChannel, request);
        }

    }

    /**
     * 广播
     * */
    private void broadCast(Selector selector, SocketChannel sourceChannel, String request){
        /**
         * 获取所有已接入的channel
         * */
        Set<SelectionKey> selectionKeySet = selector.keys();
        selectionKeySet.forEach(selectionKey -> {
            SelectableChannel targetChannel = selectionKey.channel();

            //剔除发消息的客户端
            if(targetChannel instanceof SocketChannel && targetChannel != sourceChannel){
                try {
                    ((SocketChannel)targetChannel).write(Charset.forName("UTF-8").encode(request));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }


    public static void main(String[] args) throws IOException {

        NioServer nioServer = new NioServer();
        nioServer.start();

    }





}
