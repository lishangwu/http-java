/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/15 12:46
 */

package com.atguigu.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

    public static void main(String[] args){

        try {
            URL url = new URL("http://www.baidu.com");
            System.out.println(url.getProtocol());

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            InputStream is = urlConnection.getInputStream();

            FileOutputStream fos = new FileOutputStream(new File("index.html"));
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) != -1){
                fos.write(buf, 0, len);
            }

            is.close();
            fos.close();
            urlConnection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
