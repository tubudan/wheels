package pers.hx.basicknowledge.jvm;

import java.io.IOException;

/**
 * @description:
 * @create: 2021-12-16 11:03
 */

public class ClassLoaderTest {
    public static void main(String[] args) throws IOException {
        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderTest.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderTest.class.getClassLoader().getParent().getParent());

        System.in.read();
    }
}
