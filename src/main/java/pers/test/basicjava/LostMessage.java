package pers.test.basicjava;
/**
 * @author hsiang.hu
 * @create 2020-08-05
 * @program: wheels
 * @description:
 * @create: 2020-08-05 16:33
 */
class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}

public class LostMessage {
    void f() throws VeryImportantException {
        System.out.println("enter VeryImportantException!");
        throw new VeryImportantException();
    }
    void dispose() throws HoHumException {
        System.out.println("enter HoHumException!");
        throw new HoHumException();
    }
    public static void main(String[] args)
            throws Exception {
        LostMessage lm = new LostMessage();
        try {
            System.out.println("enter try!");
            lm.f();
        } finally {
            System.out.println("enter finally!");
            lm.dispose();
        }
    }
}