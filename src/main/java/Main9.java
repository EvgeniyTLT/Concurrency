import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main9 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long millis=(long) (Math.random()*5000+1000);
                    String name = Thread.currentThread().getName();
                    System.out.println(name+ ": Data is being prepared");
                    try {
                        Thread.sleep(millis);
                        System.out.println(name+ ": Data is ready");
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name + ": continue work");
                }
            }).start();
        }







//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        Semaphore semaphore = new Semaphore(3);
//        for (int i = 0; i < 10; i++) {
//            executorService.execute(new Runnable() {
//                @Override
//                public void run() {
//                    String name = Thread.currentThread().getName();
//                    System.out.println(name + " started working.");
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    try {
//                        semaphore.acquire();
//                        workWithFileSystem();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    } finally {
//                        semaphore.release();
//                    }
//
//                    System.out.println(name + " finished working.");
//                }
//            });
//        }
//        executorService.shutdown();
    }

    private static void workWithFileSystem() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started working with file system.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + " finished working with file system.");
    }
}
