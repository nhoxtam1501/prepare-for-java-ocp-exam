package dev.ducku.ex4;

import java.time.Duration;

public class Ex4Main {

    public static volatile Integer c = 0;

    public static void main(String[] args) {

        IncrementingThread t = new IncrementingThread();
        PrintingThread printingThread = new PrintingThread();
        t.start();
        printingThread.start();
    }
}
