package ca.bcit.comp2522.sorting;

/**
 * Time manages a moment in time: hours, minutes, and seconds.
 *
 * @author BCIT
 * @version 2026
 */
public final class SimpleTime {

    /** Hours run from 0 up to but not including this value. */
    private static final int HOURS_PER_DAY = 24;

    /** Minutes run from 0 up to but not including this value. */
    private static final int MINUTES_PER_HOUR = 60;

    /** Seconds run from 0 up to but not including this value. */
    private static final int SECONDS_PER_MINUTE = 60;

    /** The hour at which the 12-hour clock rolls over from AM to PM. */
    private static final int NOON = 12;

    private int hour;
    private int minute;
    private int second;

    /**
     * Constructs an object of type Time.
     */
    public SimpleTime() {
        this(0, 0, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param h hours an int
     */
    public SimpleTime(final int h) {
        this(h, 0, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param h hours an int
     * @param m minutes an int
     */
    public SimpleTime(final int h, final int m) {
        this(h, m, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param h hours an int
     * @param m minutes an int
     * @param s seconds an int
     */
    public SimpleTime(final int h, final int m, final int s) {
        setTime(h, m, s);
    }

    /**
     * Sets the time.
     * @param h hours an int
     * @param m minutes an int
     * @param s second an int
     */
    public void setTime(final int h, final int m, final int s) {
        setHour(h);
        setMinute(m);
        setSecond(s);
    }

    /**
     * Sets the hour to the specified time.
     * @param h an int
     */
    public void setHour(final int h) {

        // Exceptions are a Week 09 topic, so an out-of-range value is not
        // rejected here. It is clamped to a documented, predictable default
        // instead. Silently accepting nonsense would be worse.
        if (h >= 0 && h < HOURS_PER_DAY) {
            hour = h;
        } else {
            hour = 0;
        }
    }

    /**
     * Sets the minute to the specified time.
     * @param m an int
     */
    public void setMinute(final int m) {
        if (m >= 0 && m < MINUTES_PER_HOUR) {
            minute = m;
        } else {
            minute = 0;
        }
    }

    /**
     * Sets the second to the specified time.
     * @param s an int
     */
    public void setSecond(final int s) {
        if (s >= 0 && s < SECONDS_PER_MINUTE) {
            second = s;
        } else {
            second = 0;
        }
    }

    /**
     * Returns the hour.
     * @return hour as an int
     */
    public int getHour() {
        return hour;
    }

    /**
     * Returns the minute.
     * @return minute as an int
     */
    public int getMinute() {
        return minute;
    }

    /**
     * Returns the second.
     * @return second as an int
     */
    public int getSecond() {
        return second;
    }

    /**
     * Returns the time formatted as HH:MM:SS.
     * @return time as HH:MM:SS
     */
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", getHour(), getMinute(), getSecond());
    }

    /**
     * Returns a string representation of this Time.
     * @return description a string
     */
    @Override
    public String toString() {

        // Midnight and noon both display as 12, not as 0. Every other hour is
        // the 24-hour value modulo 12.
        final int displayHour;
        if (getHour() == 0 || getHour() == NOON) {
            displayHour = NOON;
        } else {
            displayHour = getHour() % NOON;
        }

        final String meridiem;
        if (getHour() < NOON) {
            meridiem = "AM";
        } else {
            meridiem = "PM";
        }

        return String.format("%d:%02d:%02d %s",
                displayHour, getMinute(), getSecond(), meridiem);
    }
}
