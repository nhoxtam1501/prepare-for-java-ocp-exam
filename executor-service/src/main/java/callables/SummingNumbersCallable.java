package callables;

import java.util.concurrent.Callable;

public class SummingNumbersCallable implements Callable<Integer> {
    private static int count = 0;
    private int x, y;

    public SummingNumbersCallable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        int result = x + y;
        System.out.println("Name of thread: " + Thread.currentThread().getName());
        if (count == 0) {
            count++;
            throw new Exception("Count is 0");
        }

        return result;
    }
}
