package com.hspedu.PrintWriter_;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ��˳ƽ
 * @version 1.0
 * ��ʾ PrintWriter ʹ�÷�ʽ
 */
public class PrintWriter_ {
    public static void main(String[] args) throws IOException {

        //PrintWriter printWriter = new PrintWriter(System.out);
        PrintWriter printWriter = new PrintWriter(new FileWriter("e:\\f2.txt"));
        printWriter.print("hi, �������~~~~");
        printWriter.close();//flush + �ر���, �ŻὫ����д�뵽�ļ�..

    }
}

