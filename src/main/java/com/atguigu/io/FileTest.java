/**
 * Created by IntelliJ IDEA
 *
 * @author robin
 * @create 2019/7/14 11:07
 */

package com.atguigu.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {

    @Test
    public void test1() {

        File file = new File("jdbc.properties");
        File file1 = new File("/Users"+ File.separator +"robin/GitHub/java-study/src");

        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getAbsolutePath());

        System.out.println();

        for (String s : file1.list()) {
            System.out.println(s);
        }

        System.out.println();

        FileTest test = new FileTest();
        test.directoryStructure(file1);

    }

    @Test
    public void test2(){
        File f = new File("hi1.txt");
        if(!f.exists()){
            try {
                f.createNewFile();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }else {
            f.delete();
        }
    }

    @Test
    public void test3(){
        File f = new File("hi");
//        f.mkdirs();
        f.delete();

    }

    public void directoryStructure(File file){
        directoryStructure(file, 0);
    }

    private void directoryStructure(File file, int tab){

        if (file.exists()) {
            if (tab == 0) {
                System.out.println(file.getName());
            }else{
                for (int i = 0; i < tab; i++) {
                    System.out.print("\t");
                }
                if(file.isDirectory())
                    System.out.println(file.getName() + "/");
                else
                    System.out.println(file.getName());
            }

            if(file.isDirectory()){
                File[] files = file.listFiles();
                if (files != null) {
                    for (File file1 : files) {
                        directoryStructure(file1, tab + 1);
                    }
                }

            }
        }

    }
    public void bl(File f){
        bl(f, 0);
    }
    private void bl(File f, int level){
        if(f.exists()){

            if (level == 0) {
                System.out.println(f.getName());
            }else {
                for (int i = 0; i < level; i++) {
                    System.out.print("\t");
                }
                System.out.println(f.getName());
            }

            if (f.isDirectory()) {

                File[] files = f.listFiles();
                if (files != null) {
                    for (File file : files) {
                        bl(file, level + 1);
                    }
                }

            }

        }
    }



}
