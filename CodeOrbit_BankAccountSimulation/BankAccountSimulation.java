import java.util.ArrayList;
import java.util.Scanner;

// Class representing a bank account
class BankAccount {


private String accountHolder;
private double balance;

// Store transaction history
private ArrayList<String> transactionHistory;

// Constructor to initialize the account
public BankAccount(String accountHolder, double initialBalance) {
    this.accountHolder = accountHolder;
    this.balance = initialBalance;
    this.transactionHistory = new ArrayList<>();

    transactionHistory.add(
        String.format("Account created with balance: Rs. %.2f", initialBalance)
    );
}

// Method to deposit money
public void deposit(double amount) {

    if (amount <= 0) {
        System.out.println("Error: Deposit amount must be greater than zero.");
        transactionHistory.add("Failed deposit: Invalid amount");
        return;
    }

    balance += amount;

    transactionHistory.add(
        String.format("Deposited: Rs. %.2f | Balance: Rs. %.2f",
                      amount, balance)
    );

    System.out.printf("Successfully deposited Rs. %.2f%n", amount);
}

// Method to withdraw money
public void withdraw(double amount) {

    if (amount <= 0) {
        System.out.println("Error: Withdrawal amount must be greater than zero.");
        transactionHistory.add("Failed withdrawal: Invalid amount");
        return;
    }

    // Check whether sufficient balance is available
    if (amount > balance) {
        System.out.println("Error: Insufficient balance!");
        transactionHistory.add(
            String.format("Failed withdrawal: Rs. %.2f (Insufficient balance)",
                          amount)
        );
        return;
    }

    balance -= amount;

    transactionHistory.add(
        String.format("Withdrawn: Rs. %.2f | Balance: Rs. %.2f",
                      amount, balance)
    );

    System.out.printf("Successfully withdrawn Rs. %.2f%n", amount);
}

// Method to check the current balance
public void checkBalance() {
    System.out.printf("Account Holder: %s%n", accountHolder);
    System.out.printf("Available Balance: Rs. %.2f%n", balance);

    transactionHistory.add("Balance checked");
}

// Method to display transaction history
public void displayTransactionHistory() {

    System.out.println("\n========== TRANSACTION HISTORY ==========");

    for (int i = 0; i < transactionHistory.size(); i++) {
        System.out.println((i + 1) + ". " + transactionHistory.get(i));
    }

    System.out.println("=========================================");
}


}

// Main class
public class BankAccountSimulation {


public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {
        // Get account holder details
        System.out.print("Enter account holder name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Error: Account holder name cannot be empty.");
            return;
        }

        // Get initial balance
        System.out.print("Enter initial balance: Rs. ");
        double initialBalance = sc.nextDouble();

        if (!Double.isFinite(initialBalance) || initialBalance < 0) {
            System.out.println("Error: Initial balance must be a valid non-negative amount.");
            return;
        }

        // Create a bank account object
        BankAccount account = new BankAccount(name, initialBalance);

        int choice;

        // Display the banking menu repeatedly
        do {
            System.out.println("\n========== BANK ACCOUNT MENU ==========");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: Rs. ");
                    double depositAmount = sc.nextDouble();

                    if (!Double.isFinite(depositAmount)) {
                        System.out.println("Error: Please enter a valid amount.");
                    } else {
                        account.deposit(depositAmount);
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    double withdrawAmount = sc.nextDouble();

                    if (!Double.isFinite(withdrawAmount)) {
                        System.out.println("Error: Please enter a valid amount.");
                    } else {
                        account.withdraw(withdrawAmount);
                    }
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.displayTransactionHistory();
                    break;

                case 5:
                    account.displayTransactionHistory();
                    System.out.println("Thank you for using the Bank Account Simulation!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1 to 5.");
            }

        } while (choice != 5);

    } catch (java.util.InputMismatchException e) {

        // Handle invalid input
        System.out.println("Error: Please enter valid numeric values.");

    } finally {

        // Close the Scanner
        sc.close();
    }
}


}
