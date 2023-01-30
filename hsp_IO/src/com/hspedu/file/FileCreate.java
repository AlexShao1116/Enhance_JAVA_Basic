package com.hspedu.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {
    }
    @Test
    /*直接通过文件路径创建*/
    public void create01(){
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("成功创建文件");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    /*通过父路径文件+文件名创建*/
    public void create02(){
        File parentDirectory = new File("d:\\");
        String fileName = "new02";
        File file = new File(parentDirectory,fileName);
        try {
            file.createNewFile();
            System.out.println("成功创建文件");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    /*通过父路径+文件名创建*/
    public void create03(){
        String parentDirectory ="d:\\";
        String fileName = "new03";
        File file = new File(parentDirectory,fileName);
        try {
            file.createNewFile();
            System.out.println("成功创建文件");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
