package dev.ducku;

public class DbRunnable2 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("DB2 query completed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
