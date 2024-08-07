package dev.ducku;

public class DbRunnable1 implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("DB1 query completed");
        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }
}
