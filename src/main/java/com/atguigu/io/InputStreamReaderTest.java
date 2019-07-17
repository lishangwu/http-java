/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 18:57
 */

package com.atguigu.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderTest {

    @Test
    public void test() throws Exception{
        FileInputStream fis = new FileInputStream("hi1.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

        FileOutputStream fos = new FileOutputStream("hi2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

        char[] buf = new char[1024];
        int len;
        while ((len = isr.read(buf)) != -1){
            osw.write(buf, 0, len);
        }

        osw.close();
        isr.close();
    }

}
