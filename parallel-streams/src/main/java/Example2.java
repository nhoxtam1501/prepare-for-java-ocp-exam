import java.util.List;

public class Example2 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        long t1 = System.currentTimeMillis();
        list.parallelStream().map(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 2 * x;
        }).forEach(System.out::println);
        long t2 = System.currentTimeMillis();
        System.out.println("Time taken by parallel stream: " + (t2 - t1) + " ms");

        List<Integer> serialList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19);
        long t3 = System.currentTimeMillis();
        serialList.stream().map(x -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 2 * x;
        }).forEach(System.out::println);
        long t4 = System.currentTimeMillis();
        System.out.println("Time taken by serial stream: " + (t4 - t3) + " ms");
    }
}
