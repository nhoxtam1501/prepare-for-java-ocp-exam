import java.util.stream.Stream;

public class Example1 {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,12,13,14,15,16,17,18,19)
                .parallel() //parallel using ForkJoinPool in behind
                .forEach(x -> System.out.println(Thread.currentThread().getName() + " " + x));
    }
}
