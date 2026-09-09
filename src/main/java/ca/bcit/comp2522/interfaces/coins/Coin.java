package ca.bcit.comp2522.interfaces.coins;

import java.util.Random;

/**
 * Represents a two-sided coin that can be flipped.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class Coin implements Lockable {

    private static final Random RANDOM = new Random();

    private boolean face;
    private int key;
    private boolean locked;

    /**
     * Constructs a Coin object and flips it to give it a starting value.
     */
    public Coin() {
        flip();
        key = 0;
        locked = false;
    }

    /**
     * Returns true if the current face of the Coin is heads.
     *
     * @return true if current face is heads, else false.
     */
    public boolean getFace() {
        return face;
    }

    /**
     * Returns the key of this Coin.
     *
     * @return key an int
     */
    public int getKey() {
        return key;
    }

    /**
     * Flips this Coin by randomly choosing a face value.  The Coin cannot
     * be flipped if it is locked.
     */
    public void flip() {
        if (!locked) {
            face = RANDOM.nextBoolean();
        } else {
            System.out.println("Cannot flip, key is locked");
        }
    }

    @Override
    public void setKey(final int key) {
        if (!locked) {
            this.key = key;
        }
    }

    @Override
    public boolean lock(final int candidateKey) {
        if (!locked && this.key == candidateKey) {
                locked = true;
                return true;
        }
        return false;
    }

    @Override
    public boolean unlock(final int candidateKey) {
        if (this.key == candidateKey) {
            locked = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean locked() {
        return locked;
    }

    /**
     * Compares this Coin with another object for equality.
     *
     * This implementation compares the fields declared in Coin and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Coin
     * @return true if object is equal to this Coin
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Coin coin = (Coin) object;

        if (getFace() != coin.getFace()) {
            return false;
        }
        if (getKey() != coin.getKey()) {
            return false;
        }
        return locked() == coin.locked();
    }

    /**
     * Returns a hash code for this Coin.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Coin
     */
    @Override
    public int hashCode() {
        int result;
        if (getFace()) {
            result = 1;
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        result = usefulPrime * result + getKey();
        if (locked()) {
            result = usefulPrime * result + 1;
        } else {
            result = usefulPrime * result;
        }
        return result;
    }

    /**
     * Returns a description of this Coin.
     *
     * This implementation reports the values of the fields declared in
     * Coin. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Coin as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Coin{");
        sb.append("face=").append(getFace());
        sb.append(", key=").append(getKey());
        sb.append(", locked=").append(locked());
        sb.append('}');
        return sb.toString();
    }
}
