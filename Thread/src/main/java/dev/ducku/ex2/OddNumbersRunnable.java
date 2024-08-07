package dev.ducku.ex2;

public class OddNumbersRunnable implements Runnable {
    @Override
    public void run() {

        for (int i = 1; i <= 11; i++) {
            System.out.println(i + " " + Thread.currentThread().getName());
        }
    }
}
