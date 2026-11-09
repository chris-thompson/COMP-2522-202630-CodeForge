package ca.bcit.comp2522.sorting;

import java.util.Comparator;

/**
 * TimeComparator compares two SimpleTime objects.
 *
 * @author BCIT
 * @version 2026
 */
public class TimeComparator implements Comparator<SimpleTime> {

    /**
     * Compares the two SimpleTime arguments.
     * @param simpleTime1 a SimpleTime
     * @param simpleTime2 a SimpleTime
     * @return an int where 0 means they are the same
     *                      - means time1 < time2
     *                      + means time1 > time2
     */
    @Override
    public int compare(final SimpleTime simpleTime1, final SimpleTime simpleTime2) {
        int hourCompare = simpleTime1.getHour() - simpleTime2.getHour();
        if (hourCompare != 0) {
            return hourCompare;
        }
        int minuteCompare = simpleTime1.getMinute() - simpleTime2.getMinute();
        if (minuteCompare != 0) {
            return minuteCompare;
        }
        return simpleTime1.getSecond() - simpleTime2.getSecond();
    }
}
