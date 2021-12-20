package pers.test.basicjava;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-11-18 15:06
 */

public class TestThread {
    public static void main(String[] args) {
        /**
         * @Description 无论那种方法，都需要重写run方法，多线程【线程安全】问题主要在于多个线程访问并需要对相同的资源进行写操作、以及线程之间对资源的竞争导致的阻塞
         *
         **/

        // 方式1 new一个继承了Thread的线程类
        MyThread myThread1 = new MyThread();
        myThread1.start();

        // 方式2 匿名方法
        Thread myThread2 = new Thread() {
            public void run() {
                System.out.println("MyThread2 running !");
            }
        };
        myThread2.start();

        //方式3 实现Runnable接口
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("MyThread3 running !");
            }
        };
        Thread myThread3 = new Thread(myRunnable);
        myThread3.start();

    }

    private static class MyThread extends Thread {
        public void run() {
            System.out.println("MyThread1 running !");
        }
    }

    /**
     * @Description 解决线程安全问题：1.使用synchronize 修饰代码块、方法；2.volatile 修饰变量；3.使用线程安全的数据结构
     **/
    public static class MySynchronize {
        public synchronized void log1(String msg1, String msg2) {
            System.out.println(msg1);
            System.out.println(msg2);
        }

        public void log2(String msg1, String msg2) {
            synchronized (this) {
                System.out.println(msg1);
                System.out.println(msg2);
            }
        }
    }
}
