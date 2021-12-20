package pers.hx.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-12-07 10:38
 */

public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz) {
        //创建动态代理增强器
        Enhancer enhancer = new Enhancer();
        //设置类加载器
        enhancer.setClassLoader(clazz.getClassLoader());
        //设置被代理类
        enhancer.setSuperclass(clazz);
        //设置方法拦截器
        enhancer.setCallback(new DebugMethodInterceptor());
        //创建代理类
        return enhancer.create();
    }
}
