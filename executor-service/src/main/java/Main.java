import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        int n = Runtime.getRuntime().availableProcessors(); //number of swims lines //CPU
        try (ExecutorService executors = Executors.newFixedThreadPool(n)) { //numbers of swimmer //threads
            Runnable r = () -> { //balls that will be thrown to swimmers
                System.out.println("😃 " + Thread.currentThread().getName());
                System.out.println("Numbers of threads my machine have: " + n);
            };
            executors.submit(r);
            System.out.println("😔 " + Thread.currentThread().getName());
        }
    }
}
