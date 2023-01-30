package com.hspedu.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileInfo {
    public static void main(String[] args) {

    }

    //��ȡ�ļ�����Ϣ
    @Test
    public void info() {
        //�ȴ����ļ�����
        String filePath = "d:\\new02.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //������Ӧ�ķ������õ���Ӧ��Ϣ
        System.out.println("�ļ�����=" + file.getName());
        //getName��getAbsolutePath��getParent��length��exists��isFile��isDirectory
        System.out.println("�ļ�����·��=" + file.getAbsolutePath());
        System.out.println("�ļ�����Ŀ¼=" + file.getParent());
        System.out.println("�ļ���С(�ֽ�)=" + file.length());
        System.out.println("�ļ��Ƿ����=" + file.exists());//T
        System.out.println("�ǲ���һ���ļ�=" + file.isFile());//T
        System.out.println("�ǲ���һ��Ŀ¼=" + file.isDirectory());//F


    }
}
