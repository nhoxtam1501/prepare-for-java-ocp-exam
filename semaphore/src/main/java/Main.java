import java.util.concurrent.Semaphore;

public class Main {
    private Semaphore semaphore = new Semaphore(4, true);

    void m() {

        try {
            //T1 T2 T3 T4 T5 // we have 5 threads at this state
            semaphore.acquire();
            //T1 T2 T3 T4 only 4 thread can in this block because semaphore only allow 4 thread simultaneously
            //something happen in here
        } catch (InterruptedException e) {

        } finally {
            semaphore.release();
            //T2 released, now in acquire block will only remain this thread: T1 T3 T4 T5
        }
    }
}
