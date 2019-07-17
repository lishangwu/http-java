/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 16:27
 */

package com.nio;

import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class TestPipe {

    @Test
    public void test() throws Exception{

        Pipe pipe = Pipe.open();

        Pipe.SinkChannel sinkChannel = pipe.sink();
        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put("hello..".getBytes());
        buf.flip();
        sinkChannel.write(buf);


        //读取
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(), 0, len));

        sourceChannel.close();
        sinkChannel.close();

    }

}
