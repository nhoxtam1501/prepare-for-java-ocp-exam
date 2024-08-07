package dev.ducku;

public class Main {
    public static void main(String[] args) {
        DbRunnable1 db1 = new DbRunnable1();
        DbRunnable2 db2 = new DbRunnable2();
        Thread t1 = new Thread(db1);
        Thread t2 = new Thread(db2);

        t1.start();
        t2.start();
        try {
            t1.join();
            /*Main thread will wait forever with default join()
             , if you just want to wait for it a defined of time, use join(millis)*/
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("PROCESSING....🤖");
        System.out.println("COMPLETED");
    }
}
