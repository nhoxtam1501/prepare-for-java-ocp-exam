import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Example1 {
    /*
  ForkJoinPool -> thread pool

  Task -> T1 (T1.1, T1.2), T2 (T2.1, T2.2)

  -> RecursiveAction -----> Runnable
  -> RecursiveTask<T> ------> Callable<T>

  Scenario: having a list of integers,
            print in the console the values from the list doubled.

            [1,2,3,4,5,6,7,8,9]

            [1,2,3,4,5], [6,7,8,9]

            [1,2,3], [4,5], [6,7], [8,9]

            [1], [2,3], [4,5], [6,7], [8,9]

   */

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(new DoubleNumbersRecursiveAction(input));
    }


}

class DoubleNumbersRecursiveAction extends RecursiveAction {
    private final List<Integer> input;

    DoubleNumbersRecursiveAction(List<Integer> input) {
        this.input = input;
    }

    @Override
    protected void compute() {
        if (input.size() <= 2) {
            input.stream().map(x -> x * 2).forEach(System.out::println);
        } else {
            int mid = input.size() / 2;
            DoubleNumbersRecursiveAction t1 = new DoubleNumbersRecursiveAction(input.subList(0, mid)); // [0, mid) not include mid
            DoubleNumbersRecursiveAction t2 = new DoubleNumbersRecursiveAction(input.subList(mid, input.size())); // [0, mid) not include input.size

            invokeAll(t1, t2);
        }
    }
}
