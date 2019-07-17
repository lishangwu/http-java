/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 16:51
 */

package com.atguigu.io;

import org.junit.Test;

import java.io.*;

public class BufferedStreamTest {

    @Test
    public void test() throws Exception{

        File srcFile = new File(".gitignore");
        File destFile = new File("hi1.txt");

        //节点流
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

        //缓冲流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] bytes = new byte[1024];
        int len;
        while ((len = bis.read(bytes)) != -1){
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();
        fos.close();//内层流会自动关闭
        fis.close();


    }

}
