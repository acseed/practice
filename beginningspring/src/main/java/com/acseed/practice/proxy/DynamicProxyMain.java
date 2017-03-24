package com.acseed.practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by caohongchen on 17/3/1.
 */
public class DynamicProxyMain {
    private static void consume(Interface iface) {
        iface.getMyName();
        String name = iface.getNameById("1");
        System.out.println("name : " + name);
    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        consume(realObject);
        System.out.println("-------------------------------");

        ClassLoader classLoader = Interface.class.getClassLoader();
        Class<?>[] interfaces = new Class[] { Interface.class };
        InvocationHandler handler = new DynamicProxyHandler(realObject);
        Interface proxy = (Interface) Proxy.newProxyInstance(classLoader, interfaces, handler);

        System.out.println("i dynamicproxyMain proxy: " + proxy.getClass());
        consume(proxy);
    }
}
