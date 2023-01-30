package com.hspedu.hw3;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

/**
 * @author ��˳ƽ
 * @version 1.0
 */
public class hw3 {
    public static void main(String[] args) throws IOException {
        /**
         * (1) Ҫ��дһ��dog.properties   name=tom age=5 color=red
         * (2) ��дDog ��(name,age,color)  ����һ��dog���󣬶�ȡdog.properties ����Ӧ������������Գ�ʼ��, �����
         * (3) ��������Dog ���� �����л��� �ļ� e:\\dog.dat �ļ�
         */
        String filePath = "src\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(filePath));
        String name = properties.get("name") + ""; //Object -> String
        int age = Integer.parseInt(properties.get("age") + "");// Object -> int
        String color = properties.get("color") + "";//Object -> String

        Dog dog = new Dog(name, age, color);
        System.out.println("===dog������Ϣ====");
        System.out.println(dog);

        //��������Dog ���� �����л��� �ļ� dog.dat �ļ�
        String serFilePath = "e:\\dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(serFilePath));
        oos.writeObject(dog);

        //�ر���
        oos.close();
        System.out.println("dog�������л����...");
    }

    //�ڱ�дһ�������������л�dog
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String serFilePath = "e:\\dog.dat";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog)ois.readObject();

        System.out.println("===�����л��� dog====");
        System.out.println(dog);

        ois.close();

    }
}

class Dog implements  Serializable{
    private String name;
    private int age;
    private String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
