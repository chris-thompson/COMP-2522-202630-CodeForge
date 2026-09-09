package ca.bcit.comp2522.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Six ways to ask a collection a question, using streams.
 *
 * A stream is not a collection. A collection holds elements; a stream describes
 * a computation over elements. You build a pipeline in three parts:
 *
 *   source  -> the collection you start from, via .stream()
 *   0+ intermediate operations -> filter, map, sorted; each returns a new
 *      stream and none of them do any work yet
 *   1 terminal operation -> forEach, collect, average, count; this is the one
 *      that actually runs the pipeline
 *
 * Nothing happens until the terminal operation. That is called laziness, and
 * it is why a stream can be efficient: the elements are pulled through the
 * whole pipeline one at a time rather than copied into a new list at each step.
 *
 * A stream is also single-use. Once you have run a terminal operation on it,
 * that stream is finished; call .stream() again to start a new one.
 *
 * @author BCIT
 * @version 2026
 */
public final class StudentFun {

    /** How many students the demonstration invents. */
    private static final int SAMPLE_SIZE = 10;

    /** Generated names are this many letters long. */
    private static final int NAME_LENGTH = 8;

    /** The character code of the letter 'A'. */
    private static final int FIRST_LETTER = 'A';

    /** How many letters there are to choose from. */
    private static final int ALPHABET_SIZE = 26;

    /** Earliest birth year a generated student may have. */
    private static final int MIN_YEAR = 1998;

    /** Latest birth year a generated student may have. */
    private static final int MAX_YEAR = 2008;

    private StudentFun() { }

    /**
     * Prints every student's name using a for-each loop.
     *
     * This is the version you already know. Compare it with the next method:
     * they do exactly the same thing. Read both before deciding which you find
     * clearer, because "shorter" and "clearer" are not the same word.
     *
     * @param students a Collection of Student
     */
    public static void printStudentNames(final Collection<Student> students) {
        for (final Student student : students) {
            System.out.println(student.getName());
        }
    }

    /**
     * Prints every student's name using a stream.
     *
     * Student::getName is a method reference. It is shorthand for the lambda
     * student -> student.getName(), and it means "call getName on whatever
     * element arrives here".
     *
     * @param students a Collection of Student
     */
    public static void printStreamStudentNames(final Collection<Student> students) {
        students.stream()
                .map(Student::getName)
                .forEach(System.out::println);
    }

    /**
     * Prints the name of every student who has graduated.
     *
     * filter keeps only the elements for which the test is true. It does not
     * remove anything from the original collection — streams never modify
     * their source.
     *
     * @param students a Collection of Student
     */
    public static void printStreamGraduates(final Collection<Student> students) {
        students.stream()
                .filter(student -> student.getStanding() == Student.Standing.GRADUATE)
                .map(Student::getName)
                .forEach(System.out::println);
    }

    /**
     * Returns the average age of the students who have graduated.
     *
     * mapToInt converts the stream of Student objects into a stream of plain
     * int values, which is what lets us call average(). average() returns an
     * OptionalDouble rather than a double, because a stream with nothing in it
     * has no average to report — there is no sensible number to return, so the
     * type system makes you say what should happen in that case.
     *
     * @param students a Collection of Student
     * @return the mean age in years of the graduates, or 0 if there are none
     */
    public static double getAverageGraduateAge(final Collection<Student> students) {
        return students.stream()
                .filter(student -> student.getStanding() == Student.Standing.GRADUATE)
                .mapToInt(Student::getAgeInYears)
                .average()
                .orElse(0);
    }

    /**
     * Returns the names of all students, sorted alphabetically, as a new List.
     *
     * collect is the terminal operation you will reach for most often. It
     * gathers whatever came down the pipeline into a container of your choice.
     *
     * @param students a Collection of Student
     * @return a new List of names in alphabetical order
     */
    public static List<String> sortedNames(final Collection<Student> students) {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Groups the students by their academic standing.
     *
     * This is the operation that is genuinely painful to write by hand and
     * almost free with a stream: one line replaces a loop, a HashMap, a
     * containsKey check and a new ArrayList.
     *
     * @param students a Collection of Student
     * @return a Map from each Standing to the students who hold it
     */
    public static Map<Student.Standing, List<Student>> groupByStanding(
            final Collection<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getStanding));
    }

    /**
     * Builds a collection of invented students to demonstrate with.
     *
     * @return a Collection of randomly generated Student objects
     */
    private static Collection<Student> inventStudents() {

        // One Random, reused. Creating a new Random inside a loop is a common
        // and expensive mistake, and on a fast machine it can even hand you
        // the same "random" number several times in a row.
        final Random random = new Random();
        final Collection<Student> students = new ArrayList<>();

        for (int i = 0; i < SAMPLE_SIZE; i++) {

            final StringBuilder name = new StringBuilder();
            for (int letter = 0; letter < NAME_LENGTH; letter++) {
                name.append((char) (FIRST_LETTER + random.nextInt(ALPHABET_SIZE)));
            }

            final int year = MIN_YEAR + random.nextInt(MAX_YEAR - MIN_YEAR);
            final LocalDate birthday = LocalDate.of(year, 1, 1);

            final Student student =
                    new Student(name.toString(), birthday, null);

            if (random.nextBoolean()) {
                student.setStanding(Student.Standing.GRADUATE);
            } else {
                student.setStanding(Student.Standing.SATISFACTORY);
            }

            students.add(student);
        }

        return students;
    }

    /**
     * Drives the program.
     *
     * @param args unused
     */
    public static void main(final String[] args) {

        final Collection<Student> students = inventStudents();

        System.out.println("--- every name, with a loop ---");
        printStudentNames(students);

        System.out.println("--- every name, with a stream ---");
        printStreamStudentNames(students);

        System.out.println("--- graduates only ---");
        printStreamGraduates(students);

        System.out.println("--- names in alphabetical order ---");
        sortedNames(students).forEach(System.out::println);

        System.out.println("--- grouped by standing ---");
        groupByStanding(students).forEach((standing, group) ->
                System.out.println(standing + ": " + group.size()));

        System.out.println("--- average graduate age ---");
        System.out.println(getAverageGraduateAge(students));
    }
}
