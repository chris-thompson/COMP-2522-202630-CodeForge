package ca.bcit.comp2522.fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Copy a file from one location to another.
 *
 * @author BCIT
 * @version 2026
 */
public final class Copy {

    private Copy() {
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        var input = Path.of("src/code/streams/input");
        var output = Path.of("src/code/streams/output");
        try {
            Files.copy(input, output);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
