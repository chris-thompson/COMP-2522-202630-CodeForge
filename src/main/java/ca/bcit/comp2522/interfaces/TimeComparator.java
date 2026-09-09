package ca.bcit.comp2522.interfaces;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * TimeComparator compares two Time objects.
 *
 * @author BCIT
 * @version 2026
 */
public class TimeComparator implements Comparator<Time> {

    /** A time in the morning, for the demonstration in main. */
    private static final Time MORNING = new Time(6, 30, 34);

    /** A time in the evening, for the demonstration in main. */
    private static final Time EVENING = new Time(18, 50, 22);

    /**
     * Compares the two Time arguments.
     * @param first a Time
     * @param second a Time
     * @return an int where 0 means they are the same
     *                      - means first > second
     *                      + means first < second
     */
    @Override
    public int compare(final Time first, final Time second) {
        int hourCompare = second.getHour() - first.getHour();
        if (hourCompare != 0) {
            return hourCompare;
        }
        int minuteCompare = second.getMinute() - first.getMinute();
        if (minuteCompare != 0) {
            return minuteCompare;
        }
        return second.getSecond() - first.getSecond();
    }

    /**
     * Drives the program.
     * @param args unused
     */
    public static void main(final String[] args) {
        final TimeComparator timeComparator = new TimeComparator();

        // Two ways to order the same pair. compare() is this Comparator's
        // idea of the order; compareTo() is Time's own natural ordering. They
        // deliberately disagree, which is the whole reason Comparator exists.
        System.out.println(timeComparator.compare(MORNING, EVENING));
        System.out.println(MORNING.compareTo(EVENING));

        final ArrayList<Time> demo = new ArrayList<>();
        demo.add(MORNING);
        demo.add(EVENING);
        demo.sort(timeComparator);
        System.out.println(demo);
        demo.sort(null);
        System.out.println(demo);

    }
}
