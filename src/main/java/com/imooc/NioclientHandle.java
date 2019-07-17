/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 18:06
 */

package com.imooc;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NioclientHandle implements Runnable {

    private Selector selector;

    public NioclientHandle(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void run() {
        try {
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

    //                /**
    //                 * 接入事件
    //                 * */
    //                if (selectionKey.isAcceptable()) {
    //                    acceptHandler(serverSocketChannel, selector);
    //                }

                    /**
                     * 可读事件
                     * */
                    if (selectionKey.isReadable()) {
                        readHandler(selectionKey, selector);
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
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
         * 循环读取fuwuqi请求信息
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
         * 将fuwuqi发送的请求信息 广播给其他客户端
         * */
        if (request.length() > 0) {
            System.out.println(request);
        }

    }
}
