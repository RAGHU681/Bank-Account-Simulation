import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Account Class
class Account {
    private String accountNumber;
    private double balance;
    private List<String> transactions;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account opened with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount + " | New Balance: " + balance);
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | New Balance: " + balance);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History ---");
        for (String record : transactions) {
            System.out.println(record);
        }
    }
}

// Main Class
public class BankApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a new account
        System.out.print("Enter account number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter initial deposit: ");
        double initBalance = sc.nextDouble();
        Account account = new Account(accNum, initBalance);

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 4:
                    account.printTransactionHistory();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
