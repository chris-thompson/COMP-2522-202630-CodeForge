package ca.bcit.comp2522.interfaces;

/**
 * Time manages a moment in time: hours, minutes, and seconds.
 *
 * @author BCIT
 * @version 2026
 */
public final class Time implements Comparable<Time> {

    /**
     * The number of minutes in an hour.
     */
    public static final int HOURS_PER_MINUTE = 60;

    private int hour;
    private int minute;
    private int second;

    /**
     * Constructs an object of type Time.
     */
    public Time() {
        this(0, 0, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param hours hours an int
     */
    public Time(final int hours) {
        this(hours, 0, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param hours hours an int
     * @param minutes minutes an int
     */
    public Time(final int hours, final int minutes) {
        this(hours, minutes, 0);
    }

    /**
     * Constructs an object of type Time.
     * @param hours hours an int
     * @param minutes minutes an int
     * @param seconds seconds an int
     */
    public Time(final int hours, final int minutes, final int seconds) {
        setTime(hours, minutes, seconds);
    }

    /**
     * Sets the time.
     * @param hours hours an int
     * @param minutes minutes an int
     * @param seconds second an int
     */
    public void setTime(final int hours, final int minutes, final int seconds) {
        setHour(hours);
        setMinute(minutes);
        setSecond(seconds);
    }

    /**
     * Sets the hour to the specified time.
     * @param hours an int
     */
    public void setHour(final int hours) {
        final int hoursPerDay = 24;
        if (hours >= 0 && hours < hoursPerDay) {
            hour = hours;
        } else {
            hour = 0;
        }
    }

    /**
     * Sets the minute to the specified time.
     * @param minutes an int
     */
    public void setMinute(final int minutes) {
        if (minutes >= 0 && minutes < HOURS_PER_MINUTE) {
            minute = minutes;
        } else {
            minute = 0;
        }
    }

    /**
     * Sets the second to the specified time.
     * @param seconds an int
     */
    public void setSecond(final int seconds) {
        if (seconds >= 0 && seconds < HOURS_PER_MINUTE) {
            second = seconds;
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
     * Compares this Time with another object for equality.
     *
     * This implementation compares the fields declared in Time and requires
     * that the two objects have exactly the same runtime class. A subclass
     * that adds fields of its own must override both this method and
     * hashCode, and must override them together.
     *
     * @param object the object to compare with this Time
     * @return true if object is equal to this Time
     */
    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Time time = (Time) object;

        if (getHour() != time.getHour()) {
            return false;
        }
        if (getMinute() != time.getMinute()) {
            return false;
        }
        return getSecond() == time.getSecond();
    }

    /**
     * Returns a hash code for this Time.
     *
     * This implementation is built from exactly the fields equals compares,
     * which is what keeps the two consistent. Override this whenever you
     * override equals.
     *
     * @return a hash code for this Time
     */
    @Override
    public int hashCode() {
        int result = getHour();
        final int usefulPrime = 31;
        result = usefulPrime * result + getMinute();
        result = usefulPrime * result + getSecond();
        return result;
    }

    /**
     * Returns a description of this Time.
     *
     * This implementation reports the values of the fields declared in
     * Time. A subclass that adds fields of its own should override this
     * method and include them.
     *
     * @return this Time as a String
     */
    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder("Time{");
        sb.append("hour=").append(hour);
        sb.append(", minute=").append(minute);
        sb.append(", second=").append(second);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int compareTo(final Time other) {
        int hourCompare = getHour() - other.getHour();
        if (hourCompare != 0) {
            return hourCompare;
        }
        int minuteCompare = getMinute() - other.getMinute();
        if (minuteCompare != 0) {
            return minuteCompare;
        }
        return getSecond() - other.getSecond();
    }
}
