package dev.ducku.ex3;

public class PrintEvenNumber extends Thread {
    private String name;

    public PrintEvenNumber(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        while (Ex3Main.bucket.size() <= 20) {
            synchronized (Ex3Main.bucket) {
                int n = Ex3Main.bucket.size();
                if (n % 2 == 0) {
                    try {
                        Ex3Main.bucket.add(n + 1);
                        System.out.println(name + " print: " + n);
                        Thread.sleep(500);
                        Ex3Main.bucket.notifyAll();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    try {
                        Ex3Main.bucket.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
