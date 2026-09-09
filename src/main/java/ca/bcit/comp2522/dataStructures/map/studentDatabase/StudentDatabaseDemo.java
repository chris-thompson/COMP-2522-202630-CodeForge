package ca.bcit.comp2522.dataStructures.map.studentDatabase;

/**
 * StudentDatabaseDemo.
 *
 * @author BCIT
 * @version 2026
 */
public final class StudentDatabaseDemo {


    private StudentDatabaseDemo() {
    }

    /**
     * The main method is the point of entry. This is where the Java virtual
     * machine 'begins' the program.
     *
     * @param args command line arguments (we will learn about these later)
     */
    public static void main(final String[] args) {
        StudentDatabase students = new StudentDatabase();
        students.addStudent("Flora");
        students.addStudent("Tatsunori");
        final int excellentGrade = 95;
        final int veryGoodGrade = 85;
        students.changeQuizMark("Flora", 0, excellentGrade);
        students.changeQuizMark("Tatsunori", 0, veryGoodGrade);
        students.showQuizMarks();

        // We can also test our getQuizzes method like this:
        int[] tatsunoriQuizzes = students.getQuizzes("Tatsunori");
        System.out.println("Printing contents of Tatsunori's quiz mark array:");
        for (int i = 0; i < StudentDatabase.NUM_QUIZZES; i++) {
            System.out.print(tatsunoriQuizzes[i] + " ");
        }

    }

}
