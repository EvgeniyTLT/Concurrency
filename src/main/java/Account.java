public class Account {
    private int amount1;
    private int amount2;

    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    public Account(int amount1, int amount2) {
        this.amount1 = amount1;
        this.amount2 = amount2;
    }

    public void transferFrom1To2(int amount) {
        synchronized (monitor1) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (amount <= amount1) {
                synchronized (monitor2) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    amount1 -= amount;
                    amount2 += amount;
                }
            } else System.out.println("Insufficient funds");
        }
    }

    public void transferFrom2To1(int amount) {
        synchronized (monitor2) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (amount <= amount2) {
                synchronized (monitor1) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    amount2 -= amount;
                    amount1 += amount;
                }
            } else System.out.println("Insufficient funds");
        }
    }

    public int getAmount1() {
        return amount1;
    }

    public int getAmount2() {
        return amount2;
    }
}
