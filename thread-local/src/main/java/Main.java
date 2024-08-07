public class Main {
    static final ThreadLocal<SecurityContext> threadLocal = new ThreadLocal<SecurityContext>();

    public static void main(String[] args) {
        Runnable runnable = () -> {
            Authentication authentication = new Authentication();
            authentication.setUsername("bill");
            authentication.setPassword("12345");
            authentication.setAuthority("read");
            SecurityContext securityContext = new SecurityContext();
            securityContext.setAuthentication(authentication);
            threadLocal.set(securityContext);
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " " + securityContext.getAuthentication());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable runnable2 = () -> {
            Authentication authentication = new Authentication();
            authentication.setUsername("john");
            authentication.setPassword("1512002");
            authentication.setAuthority("write");
            SecurityContext securityContext = new SecurityContext();
            securityContext.setAuthentication(authentication);
            threadLocal.set(securityContext);
            while (true) {
                try {
                    System.out.println(Thread.currentThread().getName() + " " + securityContext.getAuthentication());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread2 = new Thread(runnable2);
        thread2.start();
    }
}
