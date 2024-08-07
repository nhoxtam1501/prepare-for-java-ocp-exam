import java.util.List;
import java.util.concurrent.RecursiveTask;

public class Example2 {
    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        SumNumbersRecursiveTask t1 = new SumNumbersRecursiveTask(input);
        System.out.println(t1.invoke());
    }
}

class SumNumbersRecursiveTask extends RecursiveTask<Integer> {
    private final List<Integer> input;

    SumNumbersRecursiveTask(List<Integer> input) {
        this.input = input;
    }

    @Override
    protected Integer compute() {
        if (input.size() <= 2) {
            return input.stream().mapToInt(i -> i).sum();
        } else {
            int mid = input.size() / 2; // middle index
            List<Integer> list1 = input.subList(0, mid); // [0, mid)
            List<Integer> list2 = input.subList(mid, input.size()); // [mid, input.size())

            SumNumbersRecursiveTask t1 = new SumNumbersRecursiveTask(list1);
            SumNumbersRecursiveTask t2 = new SumNumbersRecursiveTask(list2);

            t2.fork();
            return t1.compute() + t2.join(); //the position of join() always behind compute()
        }
    }
}
