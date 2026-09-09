package ca.bcit.comp2522.banking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests Account.
 *
 * Money is compared here with a delta rather than for exact equality. Account
 * stores its balance in a double, and as BigDecimalMoney in the numbers topic
 * shows, a double cannot hold most decimal fractions exactly. Asking whether
 * two doubles are precisely equal is therefore a bug waiting to happen, and
 * assertEquals for doubles takes a third argument for exactly this reason.
 *
 * @author BCIT
 * @version 2026
 */
class AccountTest {

    /** Tolerance for money comparisons, well below one cent. */
    private static final double DELTA = 0.0001;

    private static final double OPENING_BALANCE = 100.00;
    private static final long ACCOUNT_NUMBER = 72_354L;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account("Ada Lovelace", ACCOUNT_NUMBER, OPENING_BALANCE);
    }

    @Test
    void aNewAccountHoldsItsOpeningBalance() {
        assertEquals(OPENING_BALANCE, account.getBalance(), DELTA);
    }

    @Test
    void getAcctNumberReturnsTheAccountNumber() {
        assertEquals(ACCOUNT_NUMBER, account.getAcctNumber());
    }

    @Test
    void depositIncreasesTheBalance() {
        final double deposit = 50.00;
        account.deposit(deposit);
        assertEquals(OPENING_BALANCE + deposit, account.getBalance(), DELTA);
    }

    @Test
    void depositReturnsTheNewBalance() {
        final double deposit = 50.00;
        assertEquals(OPENING_BALANCE + deposit, account.deposit(deposit), DELTA);
    }

    @Test
    void withdrawTakesBothTheAmountAndTheFee() {
        final double amount = 20.00;
        final double fee = 1.50;
        account.withdraw(amount, fee);
        assertEquals(OPENING_BALANCE - amount - fee, account.getBalance(), DELTA);
    }

    @Test
    void addInterestIncreasesTheBalance() {
        final double before = account.getBalance();
        assertTrue(account.addInterest() > before);
    }

    @Test
    void toStringContainsTheOwnersName() {
        assertTrue(account.toString().contains("Ada Lovelace"));
    }
}
