package dev.ducku.ex4;

public class IncrementingThread extends Thread {

    @Override
    public void run() {
        try {
            while (true) {
                Ex4Main.c++;
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
