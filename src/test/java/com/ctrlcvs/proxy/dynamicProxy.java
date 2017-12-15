package com.ctrlcvs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author tsy
 * @Description
 * @date 10:19 2017/12/14
 */
public class dynamicProxy implements InvocationHandler {

    private RealSubject realSubject = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        method.invoke(realSubject, args);
        return realSubject;
    }
}
