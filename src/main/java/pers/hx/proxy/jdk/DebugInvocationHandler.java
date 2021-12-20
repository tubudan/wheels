package pers.hx.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-12-07 09:53
 */

public class DebugInvocationHandler implements InvocationHandler {

    //代理的真实对象
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用方法前的操作
        System.out.println("Before method " + method.getName());
        Object res = method.invoke(target, args);
        //调用方法后的操作
        System.out.println("After method " + method.getName());
        return res;
    }
}
