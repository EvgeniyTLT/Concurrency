import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account account = new Account(1000, 1000);

    @Test
    public void test() {
        assertEquals(1000, account.getAmount1());
        assertEquals(1000, account.getAmount2());
        account.transferFrom1To2(1100);
        account.transferFrom2To1(56000);
        assertEquals(1000, account.getAmount1());
        assertEquals(1000, account.getAmount2());
        account.transferFrom2To1(300);
        assertEquals(1300, account.getAmount1());
        assertEquals(700, account.getAmount2());
    }
}