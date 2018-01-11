package com.ctrlcvs.java8;

/**
 * @author tsy
 * @Description
 * @date 16:03 2017/12/18
 */
public class main {

    public static void execute(WorkerInterface worker) {
        worker.doSomeWork();
    }

    public static void main(String[] args) {
        //invoke doSomeWork using Annonymous class
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("Worker invoked using Anonymous class");
            }
        });

        //invoke doSomeWork using Lambda expression
        execute( () -> System.out.println("Worker invoked using Lambda expression") );
    }
}
