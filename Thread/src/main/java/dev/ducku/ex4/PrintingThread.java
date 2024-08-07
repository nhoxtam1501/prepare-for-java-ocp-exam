package dev.ducku.ex4;

public class PrintingThread extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(Ex4Main.c);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
