package pers.test.basicjava;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-06-08 10:24
 */

public class DynamicProxy {
    public String test1;
    public String test2;
    public static void main(String[] args) {
    InvocationHandler handler = new InvocationHandler() {
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println(method);
            if (method.getName().equals("morning")) {
                System.out.println("Good morning, " + args[0]);
            }
            return null;
        }
    };
    Hello hello = (Hello) Proxy.newProxyInstance(
            Hello.class.getClassLoader(), // 传入ClassLoader
            new Class[] { Hello.class }, // 传入要实现的接口
            handler); // 传入处理调用方法的InvocationHandler
    hello.morning("Bob");
}
}

interface Hello {
    void morning(String name);
}