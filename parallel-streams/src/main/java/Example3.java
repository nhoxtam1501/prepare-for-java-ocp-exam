import java.util.List;

public class Example3 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        list.parallelStream().forEachOrdered(x -> System.out.println(Thread.currentThread().getName() + " " + x));
    }
}
