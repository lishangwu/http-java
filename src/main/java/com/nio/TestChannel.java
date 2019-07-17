/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 12:33
 */

package com.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

/**
 *
 * Channel 通道：NIO中负责数据的传输，Channel本身不存储数据，需要配合缓冲区进行传输
 *
 * 主要实现类：
 * java.nio.channels.Channel 接口:
 *      FileChannel
 *      SocketChannel
 *      ServerSocketChannel
 *      DatagramChannel  (UDP)
 *
 * 获取通道: 三种方式
 *
 * 1.
 * FileInputStream / FileOutputStream
 * RandomAccessFile
 * 2.
 * Socket
 * ServerSocket
 * DatagramSocket
 * 3.
 * JDK1.7 后NIO.2各个通道提供了 静态open()
 * JDK1.7 后NIO.2 Files 工具类的newByteChannel()
 *
 *  四，通道之间的数据传输
 *  transferTo
 *  transferFrom
 *
 *  五,  分散（Scatter） 聚集（Gather）
 *  分散读取 Scattering Read ： 将通道中的数据分散到多个缓冲区
 *  聚集写入 Gather Writes ： 将多个缓冲区的数据聚集到通道中
 *
 *  六
 *  字符集 Charset
 *  编码：字符串-字节数组
 *  解码：字符数组-字符串
 *
 *  ByteBuffer  CharBuffer之间的转换
 * */

public class TestChannel {

    @Test
    public void test() throws Exception{

        FileInputStream fis = new FileInputStream("hi1.txt");
        FileOutputStream fos = new FileOutputStream("hi2.txt");

        FileChannel inChannel = fis.getChannel();
        FileChannel outChanne = fos.getChannel();

        //通道配合缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //1.通道数据-存入->缓冲区
        while (inChannel.read(buf) != -1){

            buf.flip();//切换到读取模式

            //2.缓冲区数据-写入->通道
            outChanne.write(buf);

            buf.clear();

        }

        outChanne.close();
        inChannel.close();
        fos.close();
        fis.close();
    }

    @Test
    public void test2() throws IOException {

        FileChannel inChannel = FileChannel.open(Paths.get("hi1.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("hi3.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);// 覆盖
//        ByteBuffer buf = ByteBuffer.allocate(1024);
//        while ((inChannel.read(buf)) != -1){
//            buf.flip();
//            outChannel.write(buf);
//            buf.clear();
//        }

        //内存映射文件
        MappedByteBuffer inMapBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMapBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        final byte[] dst = new byte[inMapBuf.limit()];
        inMapBuf.get(dst);
        outMapBuf.put(dst);


        outChannel.close();
        inChannel.close();
    }


    //通道之间的数据传输
    @Test
    public void test4() throws Exception{

        FileChannel inChannel = FileChannel.open(Paths.get("hi1.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("hi3.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);// 覆盖

//        inChannel.transferTo(0, inChannel.size(), outChannel);//直接缓冲区
        outChannel.transferFrom(inChannel, 0, inChannel.size());

        outChannel.close();
        inChannel.close();

    }

    //分散聚集
    @Test
    public void test5() throws Exception{

        RandomAccessFile raf1 = new RandomAccessFile("hi1.txt", "rw");

        //获取通道
        FileChannel channel = raf1.getChannel();
        //分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(200);

        //分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel.read(bufs);

        for (ByteBuffer buf : bufs) {
            buf.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("--------------------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

        System.out.println("******************************");
        System.out.println("******************************");

        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("hi2.txt", "rw");
        FileChannel channel1 = raf2.getChannel();
        channel1.write(bufs);

        raf1.close();
        raf2.close();

    }

    //字符集
    @Test
    public void test6(){

        SortedMap<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entrySet = map.entrySet();
        for (Map.Entry<String, Charset> entry : entrySet) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    @Test
    public void test6_1() throws CharacterCodingException {

        Charset cs1 = Charset.forName("GBK");//一个中文在GBK里占2个字节

        CharsetEncoder ce = cs1.newEncoder();
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("你是傻逼吗！");
        charBuffer.flip();

        //编码
        ByteBuffer encode = ce.encode(charBuffer);

        for (int i = 0; i < 12; i++) {
            System.out.println(encode.get(i));
        }


        //解码
//        encode.flip();
        CharBuffer decode = cd.decode(encode);
        System.out.println(decode.toString());
//        for (int i = 0; i < 6; i++) {
//            System.out.println(decode.get(i));
//        }

        System.out.println("******************************");
        System.out.println("******************************");

        //UTF-8
    }

    @Test
    public void test6_2() throws CharacterCodingException {

        Charset charset = Charset.forName("UTF-8");//一个中文三个字节
        CharsetEncoder charsetEncoder = charset.newEncoder();
        CharsetDecoder charsetDecoder = charset.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);
        charBuffer.put("床前明月光");
        charBuffer.flip();

        ByteBuffer encode = charsetEncoder.encode(charBuffer);
        System.out.println(encode);
        for (int i = 0; i < encode.limit(); i++) {
            System.out.println(encode.get(i));
        }

        CharBuffer decode = charsetDecoder.decode(encode);
        System.out.println(decode);


    }
}
