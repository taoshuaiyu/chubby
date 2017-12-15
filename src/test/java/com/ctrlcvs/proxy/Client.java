package com.ctrlcvs.proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author tsy
 * @Description
 * @date 10:21 2017/12/14
 */
public class Client {
    public static void main(String[] args) throws IOException {
        // Subject subject = (Subject)
        // Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
        // RealSubject.class.getInterfaces(), new dynamicProxy());
        // subject.sayHello();
        // subject.sayGoodBye();
        byte[] clasFile = ProxyGenerator.generateProxyClass("TestProxyGen",
                RealSubject.class.getInterfaces());
        File file = new File("D:\\TestProxyGen.class");
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(clasFile);
        fos.flush();
        fos.close();
    }
}
