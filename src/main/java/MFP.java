public class MFP {

    Object monitor1 = new Object();
    Object monitor2 = new Object();

    public void print(int pages) {
        synchronized (monitor1) {
            for (int i = 1; i <= pages; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Отпечатано " + i + " страницa.");

            }
        }
    }

    public void scan(int pages) {
        synchronized (monitor2) {
            for (int i = 1; i <= pages; i++) {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Отсканировано " + i + " страницa.");
            }
        }
    }
}
