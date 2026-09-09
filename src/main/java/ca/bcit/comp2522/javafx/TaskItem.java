package ca.bcit.comp2522.javafx;

/**
 * One item on a to-do list. A pure model class.
 *
 * Look at the imports at the top of this file. There are none. This class does
 * not know that JavaFX exists, and that is the single most important design
 * decision in this package.
 *
 * The rule your labs enforce from Lab 02 onward is: NO JavaFX TYPES IN MODEL
 * CLASSES. The reasons are worth stating plainly, because the rule looks like
 * bureaucracy until you have been bitten by breaking it.
 *
 *   1. You can test this class. A JUnit test can create a TaskItem, call its
 *      methods and check the answers, with no window, no display and no
 *      JavaFX runtime. Try to unit-test a class that builds a Label and you
 *      must start the whole JavaFX toolkit first.
 *
 *   2. You can change the interface without touching the model. Swap JavaFX
 *      for a web page, a console menu or a phone app and this file does not
 *      change by one character.
 *
 *   3. You can reason about it. The state of a TaskItem is three fields. The
 *      state of a JavaFX node is three fields plus everything Node inherits.
 *
 * The conversion from model to screen has to happen somewhere. It happens in
 * TaskItemAdapter, which is allowed to know about both sides.
 *
 * @author BCIT
 * @version 2026
 */
public final class TaskItem {

    private final String description;
    private final Priority priority;
    private boolean complete;

    /**
     * How urgent a TaskItem is.
     */
    public enum Priority {
        /** Can wait. */
        LOW,
        /** Ordinary work. */
        NORMAL,
        /** Needs doing today. */
        HIGH
    }

    /**
     * Constructs an incomplete TaskItem.
     *
     * @param description what needs doing
     * @param priority    how urgent it is
     */
    public TaskItem(final String description, final Priority priority) {
        this.description = description;
        this.priority = priority;
        this.complete = false;
    }

    /**
     * Returns what needs doing.
     *
     * @return the description as a String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns how urgent this TaskItem is.
     *
     * @return the Priority
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * Returns true if this TaskItem has been completed.
     *
     * @return true if complete, otherwise false
     */
    public boolean isComplete() {
        return complete;
    }

    /**
     * Marks this TaskItem complete or incomplete.
     *
     * @param complete true to mark it done
     */
    public void setComplete(final boolean complete) {
        this.complete = complete;
    }

    /**
     * Returns a description of this TaskItem.
     *
     * @return this TaskItem as a String
     */
    @Override
    public String toString() {
        final String box;
        if (complete) {
            box = "[x]";
        } else {
            box = "[ ]";
        }
        return box + " " + description + " (" + priority + ")";
    }
}
