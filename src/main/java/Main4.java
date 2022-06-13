public class Main4 {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Runnable task = blockingQueue.take();
                    if (task != null) {
                        new Thread(task).start();
                    }
                }
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            final int INDEX = i;
            blockingQueue.add(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("----" + INDEX);
                }
            });
        }

    }
}
