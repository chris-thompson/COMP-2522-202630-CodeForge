package ca.bcit.comp2522.interfaces.coins;

/**
 * Lockable is an object that can be locked.
 *
 * @author BCIT
 * @version 2026
 */
public interface Lockable {

    /**
     * Sets the key.
     *
     * @param key an int
     */
    void setKey(int key);

    /**
     * Locks the object using the specified key.
     *
     * @param key an int
     * @return true if the object was locked, else false
     */
    boolean lock(int key);

    /**
     * Unlocks the object using the specified key.
     *
     * @param key an int
     * @return true if the object was unlocked, else false
     */
    boolean unlock(int key);

    /**
     * Returns true if the object is locked.
     *
     * @return true if locked, else false
     */
    boolean locked();
}
