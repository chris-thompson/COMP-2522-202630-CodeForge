package ca.bcit.comp2522.commandLineArgs;

/**
 * Average calculates and returns the average of the
 * command line arguments, which must be integers.
 *
 * @author BCIT
 * @version 2026
 */
public final class Average {

    private Average() {
    }

    /**
     * Drives the program.
     *
     * @param args a possibly zero-length list of integers
     */
    public static void main(final String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments");
            return;
        }

        System.out.println(args[0]);


        int numberOfCommandLineArguments = args.length;
        int sum = 0;
        int count = 0;
        while (count < numberOfCommandLineArguments) {
            sum += Integer.parseInt(args[count]);
            count++;
        }
        double average = 1.0 * sum / numberOfCommandLineArguments;
        System.out.println(average);
    }
}
