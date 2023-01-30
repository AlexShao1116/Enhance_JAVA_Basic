package com.hspedu.hw2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ��˳ƽ
 * @version 1.0
 */
public class hw2 {
    public static void main(String[] args) {
        /**
         * Ҫ��:  ʹ��BufferedReader��ȡһ���ı��ļ���Ϊÿ�м����кţ�
         * ����ͬ����һ���������Ļ�ϡ�
         */

        String filePath = "d:\\a.txt";
        BufferedReader br = null;
        String line = "";
        int lineNum = 0;
        try {
            br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {//ѭ����ȡ
                System.out.println(++lineNum + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                if(br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
