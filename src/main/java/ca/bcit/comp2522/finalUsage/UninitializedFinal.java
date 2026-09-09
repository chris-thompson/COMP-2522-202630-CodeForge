package ca.bcit.comp2522.finalUsage;

class Doodad {
}

/**
 * Uninitialized final data members must be initialized in
 * the constructor. The compiler will complain if you don't.
 *
 * @author BCIT
 * @version 2026
 */
public class UninitializedFinal {

    private final int attribute = 0;
    private final int someOtherAttribute;
    private final Doodad doodad;

    UninitializedFinal() {
        someOtherAttribute = 1; // What happens if you comment out this line of code?
        doodad = new Doodad();
    }

    UninitializedFinal(final int storedValue) {
        someOtherAttribute = storedValue; // What happens if you comment out this line of code?
        doodad = new Doodad();
    }

    /**
     * Returns the value of the attribute.
     *
     * @return attribute as an int
     */
    public int getAttribute() {
        return attribute;
    }

    /**
     * Returns the value of the someOtherAttribute.
     *
     * @return someOtherAttribute as an int
     */
    public int getSomeOtherAttribute() {
        return someOtherAttribute;
    }

    /**
     * Returns the value of the doodad.
     *
     * @return doodad as a Doodad
     */
    private Doodad getDoodad() {
        return doodad;
    }

    /**
     * Compares this UninitializedFinal with another object for equality.
     *
     * This implementation compares the fields declared in UninitializedFinal and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this UninitializedFinal
     * @return true if object is equal to this UninitializedFinal
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        UninitializedFinal that = (UninitializedFinal) object;

        if (getAttribute() != that.getAttribute()) {
            return false;
        }
        if (getSomeOtherAttribute() != that.getSomeOtherAttribute()) {
            return false;
        }
        return getDoodad().equals(that.getDoodad());
    }

    /**
     * Returns a hash code for this UninitializedFinal.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this UninitializedFinal
     */
    @Override
    public int hashCode() {
        int result = getAttribute();
        final int usefulPrime = 31;
        result = usefulPrime * result + getSomeOtherAttribute();
        result = usefulPrime * result + getDoodad().hashCode();
        return result;
    }

    /**
     * Returns a description of this UninitializedFinal.
     *
     * This implementation reports the values of the fields declared in
     * UninitializedFinal. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this UninitializedFinal as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("UninitializedFinal{");
        sb.append("attribute=").append(getAttribute());
        sb.append(", someOtherAttribute=").append(getSomeOtherAttribute());
        sb.append(", doodad=").append(getDoodad());
        sb.append('}');
        return sb.toString();
    }

    /**
     * Drives the program.
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        UninitializedFinal uninitializedFinal = new UninitializedFinal();
        System.out.println(uninitializedFinal);

        final int answerToLifeTheUniverseAndEverything = 42;
        UninitializedFinal anotherUninitializedFinal =
                new UninitializedFinal(answerToLifeTheUniverseAndEverything);
        System.out.println(anotherUninitializedFinal);
    }
}
