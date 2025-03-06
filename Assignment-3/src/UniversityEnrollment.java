import java.util.Scanner;

class CourseFullException extends Exception {
    public CourseFullException(String message) {
        super(message);
    }
}

class PrerequisiteNotMetException extends Exception {
    public PrerequisiteNotMetException(String message) {
        super(message);
    }
}

public class UniversityEnrollment {
    private static final int MAX_STUDENTS = 3;
    private static int enrolledStudents = 3; // Course is full
    private static boolean hasCompletedPrerequisite = false; // Prerequisite not met

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enroll in Course: ");
            String courseName = scanner.nextLine();

            System.out.print("Prerequisite Completed? (yes/no): ");
            String prerequisiteStatus = scanner.nextLine();

            if (prerequisiteStatus.equalsIgnoreCase("yes")) {
                hasCompletedPrerequisite = true;
            }

            if (enrolledStudents >= MAX_STUDENTS) {
                throw new CourseFullException("Error: Course is full.");
            }

            if (!hasCompletedPrerequisite) {
                throw new PrerequisiteNotMetException("Error: Prerequisite not completed.");
            }

            enrolledStudents++;
            System.out.println("Enrollment Successful!");

        } catch (CourseFullException | PrerequisiteNotMetException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}
