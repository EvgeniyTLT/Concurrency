public class Main6 {
    public static void main(String[] args) {
        Account account = new Account(1000, 1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.transferFrom1To2(300);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.transferFrom1To2(500);
            }
        }).start();

        System.out.println(account.getAmount1() + " "+ account.getAmount2());
    }
}
