/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 18:25
 */

package com.imooc;

import java.io.IOException;

public class CClient {


    public static void main(String[] args){

        try {
            new NioClient().start("C");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
