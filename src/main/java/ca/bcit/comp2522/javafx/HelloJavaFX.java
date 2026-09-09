package ca.bcit.comp2522.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * The smallest JavaFX program that puts a window on the screen.
 *
 * This is the class your lab starters hand you already written, with the note
 * "this class is provided; you will understand it in Week 6; do not modify it".
 * This file is where the explanation lives. You are not expected to be able to
 * write it yet. You are expected to be able to read it by Week 6.
 *
 * Three things here are Week 6 material:
 *
 *   extends Application
 *       Application is a class that JavaFX provides. Writing "extends" means
 *       HelloJavaFX IS-A Application and inherits everything it can do. That
 *       is inheritance, and it is the whole of Week 6.
 *
 *   start(Stage), marked with the Override annotation
 *       Application already has a start method; it just does not know what
 *       your program wants to draw. Overriding it means "when JavaFX calls
 *       start, run my version instead of the inherited one". The Override
 *       annotation is you asking the compiler to check that you really are
 *       overriding something and have not, say, misspelled the name.
 *
 *   launch(args)
 *       An inherited static method that starts the JavaFX runtime, creates the
 *       window, and then calls your start method on a special thread. Note
 *       that YOU never call start yourself. You hand control to the framework
 *       and it calls back into your code. That inversion is why a GUI program
 *       is shaped so differently from the console programs you have written.
 *
 * The vocabulary is borrowed from the theatre. A Stage is the window. A Scene
 * is what is currently being shown on it. The nodes in the scene form a tree,
 * called the scene graph, with one root.
 *
 * @author BCIT
 * @version 2026
 */
public class HelloJavaFX extends Application {

    /** Width of the window in pixels. */
    private static final int WINDOW_WIDTH = 400;

    /** Height of the window in pixels. */
    private static final int WINDOW_HEIGHT = 200;

    /**
     * Builds and shows the user interface.
     *
     * JavaFX calls this for you, once, after the runtime has started. The
     * Stage it passes in is the application's main window.
     *
     * @param stage the primary window, supplied by JavaFX
     */
    @Override
    public void start(final Stage stage) {

        // A Label is a node: something that can appear in the scene graph.
        final Label greeting = new Label("Hello from JavaFX!");

        // A StackPane is a layout node. It holds other nodes and decides where
        // they go; this one simply centres whatever it is given.
        final StackPane root = new StackPane(greeting);

        // The Scene wraps the root of the node tree and gives it a size.
        final Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);

        stage.setTitle("COMP 2522");
        stage.setScene(scene);

        // Nothing is visible until this line runs.
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
