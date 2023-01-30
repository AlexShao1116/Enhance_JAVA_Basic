package com.hspedu.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileCreate {
    public static void main(String[] args) {
    }
    @Test
    /*ֱ��ͨ���ļ�·������*/
    public void create01(){
        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
            System.out.println("�ɹ������ļ�");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    /*ͨ����·���ļ�+�ļ�������*/
    public void create02(){
        File parentDirectory = new File("d:\\");
        String fileName = "new02";
        File file = new File(parentDirectory,fileName);
        try {
            file.createNewFile();
            System.out.println("�ɹ������ļ�");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    /*ͨ����·��+�ļ�������*/
    public void create03(){
        String parentDirectory ="d:\\";
        String fileName = "new03";
        File file = new File(parentDirectory,fileName);
        try {
            file.createNewFile();
            System.out.println("�ɹ������ļ�");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
