package ca.bcit.comp2522.inheritance.abstractClasses;

abstract class Drink {
    public abstract void pour();

    public void drink() {
        System.out.println("burp");
    }
}

class Beer extends Drink {
    @Override
    public void pour() {
        System.out.println("foam");
    }
}

class Juice extends Drink {
    @Override
    public void pour() {
        System.out.println("slosh");
    }

    @Override
    public void drink() {
        System.out.println("smack");
    }
}

class CraftBeer extends Beer {
    @Override
    public void drink() {
        super.drink();
        System.out.println("Meh. I think they're over-hyped.");
    }
}

/**
 * What's happening here?
 *
 * @author BCIT
 * @version 2026
 */
public final class Glass {

    private Glass() {
    }

    /**
     * Drives the program.
     * @param args command line arguments (unused)
     */
    public static void main(final String[] args) {
        Drink drink = new Juice();
        drink.pour();
        drink.drink();
        drink = new Beer();
        drink.pour();
        drink.drink();
        drink = new CraftBeer();
        drink.pour();
        drink.drink();
    }
}
