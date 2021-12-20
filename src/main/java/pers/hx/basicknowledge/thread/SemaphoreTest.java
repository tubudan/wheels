package pers.hx.basicknowledge.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @create: 2021-12-14 16:10
 */

public class SemaphoreTest {
    public static void main(String[] args) {
//        test1();
        test2();
    }

    //acquire() 与 release() 方法之间构成原子单元
    public static void test1() {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore sp = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //任务
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        sp.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程 " + Thread.currentThread().getName() + "进入，当前已有" + (3 - sp.availablePermits()) + "个并发");
                    try {
                        Thread.sleep((long) Math.random() * 10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getName() + "即将离开！");
                    sp.release();
                    System.out.println("线程" + Thread.currentThread().getName() + "已离开，当前已有" + (3 - sp.availablePermits()) + "个并发");
                }
            };
            service.execute(runnable);
        }
    }

    public static void test2() {
        final Bussiness bussiness = new Bussiness();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    bussiness.service();
                    System.out.println(Thread.currentThread().getName()+" 执行了count++");
                }
            });
        }
        executor.shutdown();
    }

    private static class Bussiness {
        private int count;

        Lock lock = new ReentrantLock();

        Semaphore sp = new Semaphore(1);

        public void service() {
//            lock.lock();
            try {
                sp.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                count++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(count);
            } catch (RuntimeException e) {
                e.printStackTrace();
            }finally {
                sp.release();
            }
        }
    }
}
