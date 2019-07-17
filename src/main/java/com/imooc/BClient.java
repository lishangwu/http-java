/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 18:25
 */

package com.imooc;

import java.io.IOException;

public class BClient {


    public static void main(String[] args){

        try {
            new NioClient().start("B");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
