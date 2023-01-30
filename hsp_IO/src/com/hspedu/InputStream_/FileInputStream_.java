package com.hspedu.InputStream_;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author ��˳ƽ
 * @version 1.0
 * ��ʾFileInputStream��ʹ��(�ֽ������� �ļ�--> ����)
 */
public class FileInputStream_ {
    public static void main(String[] args) {
    }

    /**
     * ��ʾ��ȡ�ļ�...
     * �����ֽڵĶ�ȡ��Ч�ʱȽϵ�
     * -> ʹ�� read(byte[] b)
     */
    @Test
    public void readFile01() {
        String filePath = "d:\\hello.txt";
        int readData = 0;
        FileInputStream fileInputStream = null;
        try {
            //���� FileInputStream �������ڶ�ȡ �ļ�
            fileInputStream = new FileInputStream(filePath);
            //�Ӹ���������ȡһ���ֽڵ����ݡ� ���û��������ã��˷�������ֹ��
            //�������-1 , ��ʾ��ȡ���
            while ((readData = fileInputStream.read()) != -1) {
                System.out.print((char)readData);//ת��char��ʾ
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //�ر��ļ������ͷ���Դ.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * ʹ�� read(byte[] b) ��ȡ�ļ������Ч��
     */
    @Test
    public void readFile02() {
        String filePath = "d:\\hello.txt";
        //�ֽ�����
        byte[] buf = new byte[8]; //һ�ζ�ȡ8���ֽ�.
        int readLen = 0;
        FileInputStream fileInputStream = null;
        try {
            //���� FileInputStream �������ڶ�ȡ �ļ�
            fileInputStream = new FileInputStream(filePath);
            //�Ӹ���������ȡ���b.length�ֽڵ����ݵ��ֽ����顣 �˷�����������ֱ��ĳЩ������á�
            //�������-1 , ��ʾ��ȡ���
            //�����ȡ����, ����ʵ�ʶ�ȡ���ֽ���
            while((readLen = fileInputStream.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));//��ʾ(byte,��ʼλ�ã���ȡ�ַ�����
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //�ر��ļ������ͷ���Դ.
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

