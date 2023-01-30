package com.hspedu.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 韩顺平
 * @version 1.0
 */
public class Directory_ {

    //判断 d:\\news1.txt 是否存在，如果存在就删除
    @Test
    public void deleteFile() {

        String filePath = "d:\\news1.txt";
        File file = new File(filePath);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该文件不存在...");
        }

    }

    //判断 D:\\demo02 是否存在，存在就删除，否则提示不存在
    //这里我们需要体会到，在java编程中，目录也被当做文件
    @Test
    public void deleteDir(){

        String filePath = "D:\\demo02";
        File file = new File(filePath);
        file.mkdir();
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该目录不存在...");
        }

    }

    //判断 D:\\demo\\a\\b\\c 目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void makeDirs(){
        String directoryPath = "d:\\demo\\a\\b\\c";
        File file = new File(directoryPath);
        if (file.exists()) {
            deleteFolder(new File("d:\\demo"));
            System.out.println(directoryPath + "存在..");
        } else {
           /* deleteFolder(new File("d:\\demo"));*/
            if (file.mkdirs()) { //创建一级目录使用mkdir() ，创建多级目录使用mkdirs()
                System.out.println(directoryPath + "创建成功..");
            } else {
                System.out.println(directoryPath + "创建失败...");
            }
        }

    }
    public static void deleteFolder(File file){
        //判断是否为文件,显示删除的文件名称
        if(file.isFile()){
            System.out.println("删除"+file.getName());
            file.delete();
            //不是文件的话,就是文件夹
        }else{
            //获取文件夹中的所有File对象,如果为空,则files.length为0,次处程序不执行
            File[] files=file.listFiles();
            for (int i = 0; i < files.length; i++) {
                //如果不为空,则显示显示删除的文件名称,继续调用递归
                deleteFolder(files[i]);
            }
        }
        //最后删除空文件夹!!!
        System.out.println("删除"+file.getName());
        file.delete();
    }
}
