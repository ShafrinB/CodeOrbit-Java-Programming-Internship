import java.util.Scanner;

public class SimpleCalculator {


public static void main(String[] args) {

    // Create Scanner object to get input from the user
    Scanner sc = new Scanner(System.in);

    try {
        // Get the first number
        System.out.print("Enter the first number: ");
        double num1 = sc.nextDouble();

        // Get the second number
        System.out.print("Enter the second number: ");
        double num2 = sc.nextDouble();

        // Display arithmetic operation options
        System.out.println("\nSelect an operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        // Get the user's choice
        System.out.print("Enter your choice (1-4): ");
        int choice = sc.nextInt();

        // Perform the selected arithmetic operation
        switch (choice) {

            case 1:
                System.out.println("Result: " + (num1 + num2));
                break;

            case 2:
                System.out.println("Result: " + (num1 - num2));
                break;

            case 3:
                System.out.println("Result: " + (num1 * num2));
                break;

            case 4:
                // Prevent division by zero
                if (num2 == 0) {
                    throw new ArithmeticException(
                        "Division by zero is not allowed."
                    );
                }

                System.out.println("Result: " + (num1 / num2));
                break;

            default:
                System.out.println(
                    "Invalid choice! Please select between 1 and 4."
                );
        }

    } catch (ArithmeticException e) {

        // Handle division by zero
        System.out.println("Error: " + e.getMessage());

    } catch (java.util.InputMismatchException e) {

        // Handle invalid input such as letters instead of numbers
        System.out.println(
            "Error: Invalid input. Please enter numbers only."
        );

    } finally {

        // Close the Scanner
        sc.close();
    }
}


}
