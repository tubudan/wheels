package pers.hx.basicknowledge.thread;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @program: wheels
 * @description: 继承Thread（重写run） 或者实现Runnable（重写run） 、callable（重写call，返回future对象）
 * @create: 2021-12-13 14:40
 */

public class ThreadPoolDemo {
    public static void main(String[] args)  throws InterruptedException, IOException,ExecutionException {

        /*ThreadPoolExecutor threadPoolExecutor0 = (ThreadPoolExecutor) Executors.newFixedThreadPool(5); //  创建一个固定大小的线程池

        ThreadPoolExecutor threadPoolExecutor1 = (ThreadPoolExecutor) Executors.newCachedThreadPool(); //  创建一个可以无限扩大的线程池

        ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) Executors.newSingleThreadExecutor(); //  创建一个单线程的线程池

        ThreadPoolExecutor threadPoolExecutor3 = (ThreadPoolExecutor) Executors.newScheduledThreadPool(5);//  适用于执行延时或者周期性任务*/

        //自定义参数创建
        int corePoolSize = 3;
        int maximumPoolSize = 4;
        int keepAliveTime = 10;
        TimeUnit unit = TimeUnit.SECONDS;
        //ArrayBlockingQueue 数组阻塞队列，可以限定队列长度
        //LinkedBlockingQueue 链表阻塞队列，队列没有最大值限制，maximumPoolSize设定失效
        //SynchronousQueue 同步队列，队列接到任务直接交给线程
        //DelayQueue 延迟队列，任务必须先实现Delayed接口，任务先入队列，等待指定时间再执行
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameThreadFactory();
        RejectedExecutionHandler handler = new MyIgnorePolicy();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                unit,
                workQueue,
                threadFactory,
                handler);
        executor.prestartAllCoreThreads(); // 预启动所有核心线程
        for (int i = 1; i <= 10; i++) {
            MyTask myTask = new MyTask(String.valueOf(i));
            executor.submit(myTask);
        }

        System.in.read();  //阻塞主线程
    }

    //创建线程的方式
    static class NameThreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName()+" has been created");
            return t;
        }
    }

    //当线程无法执行新任务时，抛异常（饱和策略）。一般是线程池的线程数达到最大数量，线程池无法处理新线程
    static class MyIgnorePolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            doLog(r,executor);
        }

        private void doLog(Runnable r, ThreadPoolExecutor e) {
            //可做日志记录
            System.err.println(r.toString() + " is rejected!");
        }
    }

    //需要执行的任务
    static class MyTask implements Runnable {
        private String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println(this.toString() + " is running!");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("MyTask{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

}
