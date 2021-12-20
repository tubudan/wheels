package pers.hx.basicknowledge.java8;

/**
 * @description:
 *  接口可以多实现，类单继承
 *  接口的方法是 public abstract 修饰，变量默认是 public static final 修饰
 * @create: 2021-12-17 08:43
 */
public interface InterfaceNew {
    public static final String a = "123";


//    有了default 和 static 不必再在修改接口的时候去修改实现类
    static void sm() {
        System.out.println("interface提供的方式实现");
    }

    default void def() {
        System.out.println("interface default方法");
    }

    //实现类必须要重写
    public abstract void func();
}
