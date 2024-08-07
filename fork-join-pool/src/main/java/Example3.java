import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Example3 {
    public static void main(String[] args) {
        int n = 7;
        FibonacciNReactiveTask t1 = new FibonacciNReactiveTask(n);
        System.out.println(t1.invoke());
    }
}

class FibonacciNReactiveTask extends RecursiveTask<Integer> {
    private final int n;

    FibonacciNReactiveTask(int n) {
        this.n = n;
    }

    @Override
    protected Integer compute() {
        if (n == 1 || n == 2)
            return 1;
        else {
            FibonacciNReactiveTask t1 = new FibonacciNReactiveTask(n - 1);
            FibonacciNReactiveTask t2 = new FibonacciNReactiveTask(n - 2);

            t2.fork();
            return t1.compute() + t2.join();
        }
    }
}
