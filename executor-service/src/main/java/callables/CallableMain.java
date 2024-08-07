package callables;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {

    public static void main(String[] args) {
        int n = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(n);


        //Callable<String> c1 = () -> Thread.currentThread().getName();
        var c = new SummingNumbersCallable(3, 5);
        Future<Integer> result = executorService.submit(c); //order pizza and get back result as a receipt
        //Future<String> result = executorService.submit(c1);
        //go somewhere and buy some stuffs
        try {
            //check for the pizza is ready or not, main thread will be blocked here
            var data = result.get();
            System.out.println(data);
        } catch (InterruptedException e) {

        } catch (
                ExecutionException e) { //if the pizza is burnt, you can decide for money refund or wait for 20minutes to have a new pizza(decide what to do)
            System.out.println("Exception occurred: " + e.getSuppressed());
            var retry = new SummingNumbersCallable(3, 5);
            var submitAgain = executorService.submit(retry);
            try {
                System.out.println("After retry: " + submitAgain.get());
            } catch (InterruptedException | ExecutionException ex) {
            }
        }

        executorService.shutdown();
    }
}
