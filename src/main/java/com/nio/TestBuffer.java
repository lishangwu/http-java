/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 11:53
 */

package com.nio;

import org.junit.Test;

import java.nio.ByteBuffer;

public class TestBuffer {

    @Test
    public void test(){

        System.out.println("******************************allocate");
        String str = "abcde";
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("******************************put");

        buf.put(str.getBytes());
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("******************************flip");

        buf.flip();//切换到读取数据模式
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("******************************get");

        byte[] dst = new byte[buf.limit()];
        buf.get(dst);

        String s = new String(dst, 0, dst.length);
        System.out.println(s);
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("******************************rewind");

        buf.rewind();//可重复读
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("******************************clear");
        buf.clear(); //缓冲区数据还在，处于"被遗忘状态"
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println("******************************");



    }

    @Test
    public void test2(){

        System.out.println("******************************allocate");
        String str = "abcde";

        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(str.getBytes());
        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst, 0, 2));

        buf.mark();
        buf.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));

        buf.reset();//恢复到mark位置

        //缓冲区是否还有数据
        if (buf.hasRemaining()) {
            System.out.println(buf.remaining());
        }

        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

    }

    @Test
    public void test3(){

        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());

    }


}
