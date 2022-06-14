import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main8 {

    public static void main(String[] args) {
        List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(1);
                        numbers.add(i);
                    }
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    for (int i = 0; i < 100; i++) {
                        Thread.sleep(1);
                        numbers.add(i);
                    }
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(numbers.size());
        for (int number : numbers
        ) {
            System.out.println(number);
        }

    }
}
