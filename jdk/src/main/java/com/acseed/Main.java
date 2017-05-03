package com.acseed;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by caohongchen on 17-3-11.
 */
public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        B b = new B();
        C c = new C();

        MethodInvoker invoker = new MethodInvoker();
        invoker.init(A.class);
        invoker.registClazz(b);
        invoker.registClazz(c);
        invoker.invok();
    }
}
