package com.hspedu.hw1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class hw1 {
    public static void main(String[] args) {
        String dirPath = "d:\\myfile";
        File dir = new File(dirPath);
        if(!dir.exists()){
            if(dir.mkdirs()){
                System.out.println("makdir Success");
            }else{
                System.out.println("makdir fail");
            }
        }else{
            System.out.println("dir exist");
        }

        String filePath  = dirPath + "\\hello.txt";// e:\mytemp\hello.txt
        File file = new File(filePath);
        if(!file.exists()){
            try {
                file.createNewFile();
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("hello.shr");
                bufferedWriter.close();
                System.out.println("�����ɹ����ļ��ɹ�");
            } catch (IOException e) {
                System.out.println("����ʧ��");
            }
        }else{
            System.out.println("�ļ��Ѵ���");
        }
    }
}
