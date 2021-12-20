package pers.hx.basicknowledge.synchronizedd;

/**
 * @program: wheels
 * @description: synchronized 3 种修饰方式
 * @create: 2021-12-09 14:52
 */

public class TestSynchronized {

    private static Object resource = new Object();

    synchronized void method1() {
        //非静态成员的synchronized 相当于对象锁，进入 method1() 要获得当前对象的锁
    }

    synchronized static void method2() {
        //类级别的锁，静态成员锁是加到类上面
    }

    public static void main(String[] args) {
        synchronized (resource){
            //对象锁，执行本代码块时需要获得 resource 的锁
        }

        synchronized (TestSynchronized.class) {
            //类锁 同 method2
        }
    }

}
