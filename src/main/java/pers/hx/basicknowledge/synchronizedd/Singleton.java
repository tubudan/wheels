package pers.hx.basicknowledge.synchronizedd;

/**
 * @program: wheels
 * @description:
 * @create: 2021-12-09 15:36
 */

//双重检验锁单例模式实现原理
public class Singleton {

//    为什么加volatile
//​   不加volatile可用性99.99%，不是完全安全的。原因是因为指令重排，new不是原子操作需要分三步。
//    分配空间、初始化、赋实例。二三步可能重排，导致还没初始化就有生成实例，导致生成的实例执行方法时出现异常，下一个线程生成时外层非空就有值不会生成实例了
    private volatile static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();   //非原子操作
                }
            }
        }
        return uniqueInstance;
    }
}
