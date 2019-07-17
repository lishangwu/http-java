/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 14:06
 */

package com.atguigu.reflect;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderTest {


    @Test
    public void test(){

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);

        System.out.println(parent.getParent());

    }

    @Test
    public void test2() throws IOException {

        Properties properties = new Properties();

        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //路径：默认在module的src下
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");

        properties.load(is);

        System.out.println(properties.getProperty("name"));


    }

}
