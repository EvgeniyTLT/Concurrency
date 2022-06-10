public class Main2 {
    public static void main(String[] args) {

        People people1 = new People("Ivan", 2500000);
        People people2 = new People("Petia", 2500000);
        Atm atm = new Atm();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (atm.getCash() > 0) {
                    atm.receivingMoneyFromAnAtm(people1);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (atm.getCash() > 0) {
                    atm.receivingMoneyFromAnAtm(people2);
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
