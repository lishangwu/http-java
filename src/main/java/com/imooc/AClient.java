/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/17 18:25
 */

package com.imooc;

import java.io.IOException;

public class AClient {


    public static void main(String[] args){

        try {
            new NioClient().start("A");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
