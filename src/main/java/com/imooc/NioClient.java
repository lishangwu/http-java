/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 17:22
 */

package com.imooc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.Scanner;

public class NioClient {

    public void start(String nickName) throws IOException {

        /**
         * 连接服务器
         * */
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9001));

        /**
         * 接收服务器响应
         * */
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_READ);
        new Thread(new NioclientHandle(selector)).start();


        /**
         * 发送数据
         * */
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String request = scanner.next();
            if(request != null && request.length() > 0){
                socketChannel.write(Charset.forName("UTF-8").encode(nickName + " : " + request));
            }
        }


    }

    public static void main(String[] args) throws IOException {

        NioClient nioClient = new NioClient();
        Random random = new Random();
        int num = random.nextInt(10);
        if(num > 5){
            nioClient.start("A");
        }else {
            nioClient.start("B");
        }

    }

}
