package com.hspedu.OutputStreamWriter_;

import java.io.*;

/**
 * @author ��˳ƽ
 * @version 1.0
 * ��ʾ OutputStreamWriter ʹ��
 * ��FileOutputStream �ֽ�����ת���ַ��� OutputStreamWriter
 * ָ������ı��� gbk/utf-8/utf8
 */
public class OutputStreamWriter_ {
    public static void main(String[] args) throws IOException {
        String filePath = "d:\\hsp.txt";
        String charSet = "utf-8";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), charSet);
        osw.write("hi, ��˳ƽ����");
        osw.close();
        System.out.println("���� " + charSet + " �����ļ��ɹ�~");
    }
}

