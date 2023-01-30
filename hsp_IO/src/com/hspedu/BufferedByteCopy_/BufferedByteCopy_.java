package com.hspedu.BufferedByteCopy_;

import java.io.*;

public class BufferedByteCopy_ {
    String bisPath = "d//a.pdf";
    String bosPath = "d//b.pdf";
    BufferedInputStream bis = null;
    BufferedOutputStream bos = null;

    {
        try {
            bis = new BufferedInputStream(new FileInputStream(bisPath));
            bos = new BufferedOutputStream(new FileOutputStream(bosPath));

            byte[] buff = new byte[1024];
            int readLen = 0;
            while((readLen = bis.read(buff)) != -1){
                bos.write(buff,0,readLen);
            }
            System.out.println("Copy Success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
