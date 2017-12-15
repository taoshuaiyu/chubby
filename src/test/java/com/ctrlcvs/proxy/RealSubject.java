package com.ctrlcvs.proxy;

/**
 * @author tsy
 * @Description
 * @date 10:20 2017/12/14
 */
public class RealSubject implements Subject {
    public void sayHello() {
        System.out.println("Hello World");
    }

    public void sayGoodBye() {
        System.out.println("GoodBye World");
    }

}
