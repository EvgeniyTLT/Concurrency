public class Atm {

    private double cash = 10_000_000;

    public double getCash() {
        return cash;
    }

    public synchronized void receivingMoneyFromAnAtm(People people) {
        try {
            System.out.println(people.getName() + " Подошел к банкомату");
            Thread.sleep(2000);
            if (cash >= people.getSalary()) {
                double result = cash - people.getSalary();
                System.out.println(people.getName() + " вывел: " + people.getSalary() + " в банкомате осталось: " + result);
                cash = result;
            } else {
                System.out.println("В банкомате не достаточно денег для " + people.getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
