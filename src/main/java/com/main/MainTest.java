/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/10 18:25
 */

package com.main;

public class MainTest {

    public static void main(String[] args){
        
        Main.main(new String[100]);
                
    }
}

class Main{
    public static void main(String[] args){

        for (int i = 0; i < args.length; i++) {
            args[i] = "args_" + i;
            System.out.println(args[i]);
        }
                
    }
}