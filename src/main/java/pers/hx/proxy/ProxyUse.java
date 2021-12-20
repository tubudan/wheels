package pers.hx.proxy;

import pers.hx.proxy.cglib.CglibProxyFactory;
import pers.hx.proxy.jdk.JdkProxyFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: hsiang.hu
 * @program: wheels
 * @description:
 * @create: 2021-12-07 10:03
 */

public class ProxyUse {
    public static void main(String[] args) {
        /**
         * @Description jdkProxy
         *              JDK 动态代理只能代理实现了接口的类或者直接代理接口
         * @params [args]
         * @return void
         **/
        ISmsService smsService = (ISmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.get("test jdkProxy");

        /*SmsServiceImpl smsService2 = (SmsServiceImpl) JdkProxyFactory.getProxy(new SmsServiceImpl());   //编译通过，但是抛出运行时 ClassCastException
        smsService2.send("test");*/

        /**
         * @Description  cglibProxy
         *               CGLIB 动态代理是通过生成一个被代理类的子类来拦截被代理类的方法调用，因此不能代理声明为 final 类型的类和方法。
         * @params [args]
         * @return void
         **/

        AliSmsService aliSmsService = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        aliSmsService.send("test cglibProxy");
    }
}
