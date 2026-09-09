package ca.bcit.comp2522.javafx;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 * Turns a TaskItem into something JavaFX can draw.
 *
 * This is the adapter, and it is the only class in this package that knows
 * about both a TaskItem and a JavaFX Node. Everything JavaFX-shaped lives on
 * this side of the line; everything about what a task actually IS lives in
 * TaskItem on the other side.
 *
 * A useful test of whether you have drawn the line in the right place: could
 * you delete this file, write a completely different one that renders TaskItem
 * objects as HTML, and change nothing else? If yes, the line is right.
 *
 * @author BCIT
 * @version 2026
 */
public final class TaskItemAdapter {

    /** Horizontal gap between the checkbox and the text, in pixels. */
    private static final int SPACING = 8;

    private TaskItemAdapter() {
    }

    /**
     * Builds a JavaFX node that displays one TaskItem.
     *
     * The adapter reads from the model and writes to the screen. Note that the
     * TaskItem is not modified and does not need to change in any way to be
     * displayed.
     *
     * @param task the TaskItem to render
     * @return a Node showing that task
     */
    public static Node toNode(final TaskItem task) {

        final CheckBox done = new CheckBox();
        done.setSelected(task.isComplete());

        // When the box is ticked on screen, update the model. This is the one
        // place the two sides are wired together.
        done.setOnAction(event -> task.setComplete(done.isSelected()));

        final Label description = new Label(task.getDescription());
        description.setTextFill(colourFor(task.getPriority()));

        return new HBox(SPACING, done, description);
    }

    /**
     * Chooses a display colour for a priority.
     *
     * Note that TaskItem.Priority carries no colour of its own. A colour is a
     * presentation decision, so it is made here and not in the model.
     *
     * @param priority the priority to choose a colour for
     * @return the Color to draw that priority in
     */
    private static Color colourFor(final TaskItem.Priority priority) {

        final Color colour;

        switch (priority) {
            case HIGH -> colour = Color.CRIMSON;
            case NORMAL -> colour = Color.BLACK;
            case LOW -> colour = Color.GREY;
            default -> colour = Color.BLACK;
        }

        return colour;
    }
}
