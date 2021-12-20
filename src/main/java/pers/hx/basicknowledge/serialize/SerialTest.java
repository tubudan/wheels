package pers.hx.basicknowledge.serialize;

import java.io.*;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-11-16 14:22
 */

public class SerialTest {
    public static void main(String[] args) {

        try {
            /* 序列化
            Person p = new Person(1L, "abc");
            System.out.println("person Serial" + p);
            FileOutputStream fileOutputStream = new FileOutputStream("person.txt");
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(p);
            outputStream.flush();
            outputStream.close();*/

            /*反序列化*/
            FileInputStream fileInputStream = new FileInputStream("person.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Person person;
            person = (Person) objectInputStream.readObject();
            System.out.println(person);
            System.out.println(person.userName);
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
