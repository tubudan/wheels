package pers.hx.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-12-07 10:35
 */

public class DebugMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method :" + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after method :" + method.getName());
        return object;
    }
}
