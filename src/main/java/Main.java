public class Main {
    public static void main(String[] args) {
        System.out.println("Start");
        Thread thread = new MyThread();
        thread.start();
        for (int i = 0; i < 1000; i++) {
            System.out.print("M");
        }
        System.out.println("\nFinish");
    }
}
