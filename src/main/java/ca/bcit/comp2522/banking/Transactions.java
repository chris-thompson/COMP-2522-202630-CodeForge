package ca.bcit.comp2522.banking;

/**
 * Demonstrates the creation and use of multiple Account objects.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Transactions {

    /**
     * Fee for a single withdrawal.
     */
    public static final double WITHDRAWAL_FEE = 1.50;

    private Transactions() {
    }

    /**
     * Creates some bank accounts and requests various services.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        final Account accountOne = new Account("Grace Hopper", 72354, 102.56);
        final Account accountTwo = new Account("Edsgar Dijkstra", 69713, 40.00);
        final Account accountThree = new Account("James Gosling", 93757, 759.32);

        final double hopperDeposit = 25.85;
        accountOne.deposit(hopperDeposit);

        final double dijkstraBalance = accountTwo.deposit(500.00);
        System.out.println("Dijkstra balance after deposit: "
                + dijkstraBalance);

        final double dijkstraWithdrawal = 430.75;
        System.out.println("Dijkstra balance after withdrawal: "
                + accountTwo.withdraw(dijkstraWithdrawal, WITHDRAWAL_FEE));

        double interestAccrued = accountOne.addInterest();
        interestAccrued += accountTwo.addInterest();
        interestAccrued += accountThree.addInterest();

        System.out.println(interestAccrued);
        System.out.println(accountOne);
        System.out.println(accountTwo);
        System.out.println(accountThree);
    }
}
