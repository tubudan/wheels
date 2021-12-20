package pers.hx.proxy.jdk;

import pers.hx.proxy.jdk.DebugInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-12-07 10:00
 */

public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target)
        );
    }
}

