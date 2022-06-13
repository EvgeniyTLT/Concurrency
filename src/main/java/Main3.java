import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread thread = new Thread(r);
                thread.setDaemon(true);
                return thread;
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                int seconds = 0;
                try {
                    while (true) {
                        System.out.println(seconds);
                        Thread.sleep(1000);
                        seconds++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("...");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finish");
    }
}
