package pers.hx.basicknowledge.thread;

/**
 * @program: wheels
 * @description:
 * @create: 2021-12-09 13:32
 */
/*
new 一个Thread,线程进入了新建的状态，调用start方法时，才会启动一个线程并让其进入就绪状态，等待cpu时间片，获得时间片后就开始运行，执行run方法的内容
直接调用run方法，相当于调用一个普通方法，并非在线程中执行
*/
public class DeadLockDemo {
    private static Object resource1 = new Object();

    private static Object resource2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread()+" 创建");
            synchronized (resource1) {
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        }, "线程1").start();

        new Thread(() ->{
            System.out.println(Thread.currentThread()+" 创建");
            synchronized (resource1){
                System.out.println(Thread.currentThread() + "get resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + "waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread() + "get resource2");
                }
            }
        },"线程2").start();
    }
}
