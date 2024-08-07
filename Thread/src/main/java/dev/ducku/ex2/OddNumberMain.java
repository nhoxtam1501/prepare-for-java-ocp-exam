package dev.ducku.ex2;

public class OddNumberMain {
    public static void main(String[] args) {

        OddNumbersRunnable oddNumbersRunnable = new OddNumbersRunnable();

        Thread t1 = new Thread(oddNumbersRunnable);
        Thread t2 = new Thread(oddNumbersRunnable);


        t1.start();
        t2.start();

    }
}
