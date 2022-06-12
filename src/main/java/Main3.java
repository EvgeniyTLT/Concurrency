import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main3 {
    public static void main(String[] args) {
        Long after = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(3);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("1 start");
                int result = 0;
                for (int i = 1; i <= 1_000_000; i++) {
                    if (i % 2 == 0) {
                        result += i;
                    }
                }
                System.out.println(result + " 1");
                System.out.println("1 stop");
                countDownLatch.countDown();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("2 start");
                int result = 0;
                for (int i = 1; i <= 100000; i++) {
                    if (i % 7 == 0) {
                        result += i;
                    }
                }
                System.out.println(result + " 2");
                System.out.println("2 stop");
                countDownLatch.countDown();
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("3 start");
                int counter = 0;
                List<Integer> numbers = new ArrayList<>();
                for (int i = 0; i < 1000; i++) {
                    numbers.add(((int) (Math.random() * 10)));
                }
                for (Integer number : numbers) {
                    if (number % 2 == 0) {
                        counter++;
                    }
                }
                System.out.println(counter + " 3");
                System.out.println("3 stop");
                countDownLatch.countDown();
            }
        });
        executorService.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Long before = System.currentTimeMillis();
        System.out.println("Time: " + (before - after));
    }
}
