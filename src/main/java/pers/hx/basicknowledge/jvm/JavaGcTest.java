package pers.hx.basicknowledge.jvm;

/**
 * @description:
 * 堆内存分配机制
 *  1.对象优先在 eden 区分配
 *  2.大对象直接进入老年代
 * @create: 2021-12-15 11:13
 */

public class JavaGcTest {
    public static void main(String[] args) {
//        byte[] bytes1 = new byte[1 * 1024 * 1024];
//        byte[] bytes2 = new byte[1 * 1024 * 1024];
//        byte[] bytes3 = new byte[1 * 1024 * 1024];
//        makeGarbage(34);
//        byte[] byteArr = new byte[10 * 1024 * 1024];
//        makeGarbage(34);
        byte[] allocation1 = new byte[65536 * 1024];
        byte[] allocation2 = new byte[900 * 1024];
        byte[] allocation3 = new byte[900 * 1024];
        byte[] allocation4 = new byte[900 * 1024];
        byte[] allocation5 = new byte[900 * 1024];

    }

    public static void makeGarbage(int size) {
        byte[] byteArrTemp = new byte[size * 1024 * 1024];
    }
}
