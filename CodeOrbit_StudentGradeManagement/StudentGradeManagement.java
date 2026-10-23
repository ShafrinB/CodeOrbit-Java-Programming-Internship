import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagement {


public static void main(String[] args) {

    // Create Scanner object to get input from the user
    Scanner sc = new Scanner(System.in);

    // Create ArrayLists to store student names and marks
    ArrayList<String> studentNames = new ArrayList<>();
    ArrayList<Double> studentMarks = new ArrayList<>();

    try {
        // Get the number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        // Validate the number of students
        if (n <= 0) {
            System.out.println("Number of students must be greater than zero.");
            return;
        }

        // Get each student's name and marks
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println("Name cannot be empty. Please try again.");
                i--;
                continue;
            }

            System.out.print("Enter marks (0-100): ");
            double marks = sc.nextDouble();
            sc.nextLine();

            // Validate marks
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Enter marks between 0 and 100.");
                i--;
                continue;
            }

            // Store student details
            studentNames.add(name);
            studentMarks.add(marks);
        }

        // Initialize variables for calculations
        double total = 0;
        double highest = studentMarks.get(0);
        double lowest = studentMarks.get(0);

        // Calculate total, highest, and lowest marks
        for (double marks : studentMarks) {

            total += marks;

            if (marks > highest) {
                highest = marks;
            }

            if (marks < lowest) {
                lowest = marks;
            }
        }

        // Calculate average marks
        double average = total / studentMarks.size();

        // Display the formatted summary report
        System.out.println("\n==================================");
        System.out.println("   STUDENT GRADE SUMMARY REPORT");
        System.out.println("==================================");

        System.out.printf("%-20s %s%n", "Student Name", "Marks");
        System.out.println("----------------------------------");

        for (int i = 0; i < studentNames.size(); i++) {
            System.out.printf(
                "%-20s %.2f%n",
                studentNames.get(i),
                studentMarks.get(i)
            );
        }

        System.out.println("----------------------------------");
        System.out.printf("Total Students : %d%n", studentNames.size());
        System.out.printf("Average Marks  : %.2f%n", average);
        System.out.printf("Highest Marks  : %.2f%n", highest);
        System.out.printf("Lowest Marks   : %.2f%n", lowest);
        System.out.println("==================================");

    } catch (java.util.InputMismatchException e) {

        // Handle invalid input
        System.out.println("Error: Please enter valid numeric values.");

    } finally {

        // Close the Scanner
        sc.close();
    }
}


}
