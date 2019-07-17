/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/7 13:21
 */

package com.httphandle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class JavaHttpHandle {

    public static void main(String[] args){
        
        JavaHttpHandle jhh = new JavaHttpHandle();
        jhh.sendGet("http://www.baidu.com");
//        jhh.sendPost("http://127.0.0.1:5000/user/login.do", "username=aa&password=qq");
                
    }

    public void sendGet(String urlAddress){
        try {
            HttpURLConnection urlConnection = null;
            URL url = new URL(urlAddress);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.setUseCaches(false);
            urlConnection.setRequestProperty("Cookie", "x=y");
            urlConnection.connect();


            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendPost(String urlAddress, String paramValue){
        try {
            HttpURLConnection urlConnection = null;
            URL url = new URL(urlAddress);

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.connect();


            PrintWriter pw = new PrintWriter(urlConnection.getOutputStream());
            pw.print(paramValue);
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }

//            System.out.println(urlConnection.getHeaderField("Set-Cookie"));

            Map<String, List<String>> map = urlConnection.getHeaderFields();
            List list = map.get("Set-Cookie");
            for (int i = 0; i < list.size(); i++) {
//                System.out.println(list.get(i));
                String temp = list.get(i).toString();
                String value[] = temp.split(";");
                System.out.println(value[0]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
