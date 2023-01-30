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
                System.out.println("创建成功新文件成功");
            } catch (IOException e) {
                System.out.println("创建失败");
            }
        }else{
            System.out.println("文件已存在");
        }
    }
}
