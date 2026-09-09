package ca.bcit.comp2522.javafx;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Shows a list of TaskItems on screen, through the adapter.
 *
 * Read the three classes in order — TaskItem, then TaskItemAdapter, then this
 * one — and notice the direction the knowledge flows in:
 *
 *     TaskItem          knows about nothing
 *     TaskItemAdapter   knows about TaskItem and about JavaFX
 *     TaskBoardApp      knows about all three
 *
 * Dependencies point one way only, from the changeable outside towards the
 * stable middle. Nothing ever points back into the model. That shape has a
 * name, which you will meet formally in Week 12 as the dependency inversion
 * principle, and it is worth recognising by sight long before then.
 *
 * @author BCIT
 * @version 2026
 */
public class TaskBoardApp extends Application {

    /** Width of the window in pixels. */
    private static final int WINDOW_WIDTH = 360;

    /** Height of the window in pixels. */
    private static final int WINDOW_HEIGHT = 240;

    /** Vertical gap between rows, in pixels. */
    private static final int ROW_SPACING = 6;

    /**
     * Builds the list of tasks to display.
     *
     * This method contains no JavaFX at all. It could be unit tested exactly
     * as it stands.
     *
     * @return the TaskItems to show
     */
    private static List<TaskItem> buildTasks() {

        final List<TaskItem> tasks = new ArrayList<>();
        tasks.add(new TaskItem("Read the lab specification", TaskItem.Priority.HIGH));
        tasks.add(new TaskItem("Write the JUnit tests first", TaskItem.Priority.HIGH));
        tasks.add(new TaskItem("Run the Checkstyle report", TaskItem.Priority.NORMAL));
        tasks.add(new TaskItem("Commit with a decent message", TaskItem.Priority.NORMAL));
        tasks.add(new TaskItem("Rename every variable called temp", TaskItem.Priority.LOW));

        // Nothing above mentions a window, a colour or a checkbox. That is the
        // point: the model is built first and completely, and only then is it
        // handed to something that knows how to draw it.
        return tasks;
    }

    /**
     * Builds and shows the user interface.
     *
     * @param stage the primary window, supplied by JavaFX
     */
    @Override
    public void start(final Stage stage) {

        final VBox root = new VBox(ROW_SPACING);
        root.getChildren().add(new Label("Today"));

        // The adapter is the only thing that converts a model object into a
        // node. This loop does not know how a TaskItem is drawn and does not
        // need to.
        for (final TaskItem task : buildTasks()) {
            root.getChildren().add(TaskItemAdapter.toNode(task));
        }

        stage.setTitle("COMP 2522 — model and adapter");
        stage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        stage.show();
    }

    /**
     * Drives the program.
     *
     * @param args passed straight through to the JavaFX runtime
     */
    public static void main(final String[] args) {
        launch(args);
    }
}
