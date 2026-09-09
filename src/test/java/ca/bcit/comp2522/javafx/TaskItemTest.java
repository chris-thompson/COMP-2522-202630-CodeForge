package ca.bcit.comp2522.javafx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests TaskItem, and in doing so demonstrates why the model/adapter split
 * exists at all.
 *
 * This file is the payoff for the rule "no JavaFX types in model classes".
 * TaskItem imports nothing from JavaFX, so these tests run in milliseconds
 * with no window, no display, no JavaFX runtime and no special test harness.
 * Had TaskItem built its own CheckBox and Label, none of this would be
 * possible without starting the entire JavaFX toolkit first.
 *
 * There is deliberately no test for TaskItemAdapter here. The adapter is
 * presentation code, it needs a live toolkit, and testing that a Label ends up
 * the right shade of red is not a good use of anybody's time. Push the logic
 * into the model, test the model, and keep the untestable part thin.
 *
 * @author BCIT
 * @version 2026
 */
class TaskItemTest {

    private TaskItem task;

    @BeforeEach
    void setUp() {
        task = new TaskItem("Write the tests first", TaskItem.Priority.HIGH);
    }

    @Test
    void getDescriptionReturnsTheDescription() {
        assertEquals("Write the tests first", task.getDescription());
    }

    @Test
    void getPriorityReturnsThePriority() {
        assertEquals(TaskItem.Priority.HIGH, task.getPriority());
    }

    @Test
    void aNewTaskIsNotComplete() {
        assertFalse(task.isComplete());
    }

    @Test
    void markingATaskCompleteChangesItsState() {
        task.setComplete(true);
        assertTrue(task.isComplete());
    }

    @Test
    void aCompletedTaskCanBeReopened() {
        task.setComplete(true);
        task.setComplete(false);
        assertFalse(task.isComplete());
    }

    @Test
    void anIncompleteTaskPrintsAnEmptyBox() {
        assertTrue(task.toString().startsWith("[ ]"));
    }

    @Test
    void aCompleteTaskPrintsATickedBox() {
        task.setComplete(true);
        assertTrue(task.toString().startsWith("[x]"));
    }
}
