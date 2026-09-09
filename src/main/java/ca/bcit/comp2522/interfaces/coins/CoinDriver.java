package ca.bcit.comp2522.interfaces.coins;

/**
 * Demonstrate how to use the Lockable interface.
 *
 * @author BCIT
 * @version 2026
 */
public final class CoinDriver {

    private CoinDriver() {
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {
        final Coin myCoin = new Coin();
        if (myCoin.locked()) {
            System.out.println("My coin is locked");
        } else {
            System.out.println("My coin is not" + " locked");
        }
        myCoin.flip();
        System.out.println(myCoin);
        final int key = 22;
        myCoin.setKey(key);
        myCoin.lock(key);
        myCoin.flip();
        System.out.println(myCoin);
        myCoin.unlock(key);
        myCoin.flip();
        System.out.println(myCoin);
        myCoin.flip();
        System.out.println(myCoin);
        myCoin.flip();
        System.out.println(myCoin);
    }
}
