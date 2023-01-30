package com.hspedu.InputStreamReader_;

import java.io.*;

/**
 * @author ��˳ƽ
 * @version 1.0
 * ��ʾʹ�� InputStreamReader ת�������������������
 * ���ֽ��� FileInputStream ת���ַ���  InputStreamReader, ָ������ gbk/utf-8
 */
public class InputStreamReader_ {
    public static void main(String[] args) throws IOException {

        String filePath = "d:\\ok.txt";
        //���
        //1. �� FileInputStream ת�� InputStreamReader
        //2. ָ������ gbk
        //InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), "gbk");
        //3. �� InputStreamReader ���� BufferedReader
        //BufferedReader br = new BufferedReader(isr);

        //��2 �� 3 ����һ��
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath), "gbk"));

        //4. ��ȡ
        String s = br.readLine();
        System.out.println("��ȡ����=" + s);
        //5. �ر������
        br.close();
    }
}
