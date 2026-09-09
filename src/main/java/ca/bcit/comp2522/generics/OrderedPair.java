package ca.bcit.comp2522.generics;

/**
 * OrderedPair.
 *
 * @author BCIT
 * @version 2026
 * @param <K> the type of the key
 * @param <V> the type of the value
 */
public final class OrderedPair<K, V> {

    private final K first;
    private final V second;

    /**
     * Constructor for objects of type OrderedPair.
     *
     * @param key the key
     * @param value the value
     */
    public OrderedPair(final K key, final V value) {
        this.first = key;
        this.second = value;
    }

    /**
     * Returns the key.
     * @return first the key as a K
     */
    public K getFirst() {
        return first;
    }

    /**
     * Returns the value.
     * @return second the value as a V
     */
    public V getSecond() {
        return second;
    }

    /**
     * Compares this OrderedPair with another object for equality.
     *
     * This implementation compares the fields declared in OrderedPair and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this OrderedPair
     * @return true if object is equal to this OrderedPair
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        OrderedPair<?, ?> that = (OrderedPair<?, ?>) object;

        if (getFirst() != null) {
            if (!getFirst().equals(that.getFirst())) {
                return false;
            }
        } else {
            if (that.getFirst() != null) {
                return false;
            }
        }
        if (getSecond() != null) {
            return getSecond().equals(that.getSecond());
        }
        return that.getSecond() == null;
    }

    /**
     * Returns a hash code for this OrderedPair.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this OrderedPair
     */
    @Override
    public int hashCode() {
        int result;
        if (getFirst() != null) {
            result = getFirst().hashCode();
        } else {
            result = 0;
        }
        final int usefulPrime = 31;
        if (getSecond() != null) {
            result = usefulPrime * result + getSecond().hashCode();
        } else {
            result = usefulPrime * result;
        }
        return result;
    }
}
