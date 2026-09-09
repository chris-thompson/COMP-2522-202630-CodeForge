package ca.bcit.comp2522.staticModifier;

/**
 * Demonstrates the use of the static modifier.
 *
 * @author Lewis and Loftus 9e
 * @author BCIT
 * @version 2026
 */
public final class SloganCounter {

    private SloganCounter() {
    }

    /**
     * Creates several Slogan objects and prints the number of objects that were
     * created.
     *
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        Slogan slogan;
        System.out.println(Slogan.getCount());

        slogan = new Slogan("Be yourself; everyone else is already taken.");
        System.out.println(slogan);
        System.out.println(Slogan.getCount());

        slogan = new Slogan("One small positive thought in the morning can change your whole day.");
        System.out.println(slogan);
        System.out.println(Slogan.getCount());

        slogan = new Slogan("""
                Fear is the mind-killer.
                I must not fear.
                Fear is the little-death that brings total obliteration.
                I will face my fear.
                I will permit it to pass over me and through me.
                And when it has gone past, I will turn the inner eye to see its path.
                Where the fear has gone there will be nothing. Only I will remain.""");
        System.out.println(slogan);
        System.out.println(Slogan.getCount());

        slogan = new Slogan("Well done is better than well said.");
        System.out.println(slogan);
        System.out.println(Slogan.getCount());

        slogan = new Slogan("Write Once, Run Anywhere.");
        System.out.println(slogan);
        System.out.println(Slogan.getCount());

        System.out.println();
        System.out.println("Slogans created: " + Slogan.getCount());

    }
}
