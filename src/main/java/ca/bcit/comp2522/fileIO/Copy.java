package ca.bcit.comp2522.fileIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

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
        Path input = Path.of("staff.txt");
        Path output = Path.of("staffCopy.txt");
        try {
            Files.copy(input, output, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Copied " + input + " to " + output);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
