import java.util.concurrent.*;

public class Race {
    private static final int CARS_COUNT_IN_TUNNEL = 3;
    private static final Semaphore tunnelSemaphore = new Semaphore(CARS_COUNT_IN_TUNNEL);
    private static final int CARS_COUNT = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {


    }

    private static void sleepRandomTime() {
        long millis = (long) (Math.random() * 5000 + 1000);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void prepare(int index) {
        System.out.println(index + " started preparing");
        sleepRandomTime();
        System.out.println(index + " finished preparing");
    }

    private static void roadFirst(int index) {
        System.out.println(index + " started roadFirst");
        sleepRandomTime();
        System.out.println(index + " finished roadFirst");
    }

    private static void roadSecond(int index) {
        System.out.println(index + " started roadSecond");
        sleepRandomTime();
        System.out.println(index + " finished roadSecond");
    }

    private static void tunnel(int index) {
        try {
            tunnelSemaphore.acquire();
            System.out.println(index + " started tunnel");
            sleepRandomTime();
            System.out.println(index + " finished tunnel");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            tunnelSemaphore.release();
        }
    }
}
