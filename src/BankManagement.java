import java.util.Scanner;

class BankAcc {
    String accountHolder;
    int accountNumber;
    String accountType;
    double balance;
    String history = "";

    // Constructor
    BankAcc(String accountHolder, int accountNumber,
            String accountType, double balance) {

        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Deposit
    void deposit(double amount) {
        balance += amount;
        history += "Deposited ₹" + amount + "\n";
        System.out.println("₹" + amount + " deposited successfully.");
    }

    // Withdraw
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history += "Withdrawn ₹" + amount + "\n";
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    // Check Balance
    void checkBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Transaction History
    void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No Transactions Yet.");
        } else {
            System.out.println("\nTransaction History:");
            System.out.println(history);
        }
    }

    // Interest Calculator
    void calculateInterest(double rate) {
        double interest = balance * rate / 100;
        System.out.println("Interest Amount: ₹" + interest);
    }

    // Display Details
    void display() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Type   : " + accountType);
        System.out.println("Balance        : ₹" + balance);
    }
}

public class BankManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Account Type (Savings/Current): ");
        String type = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAcc account = new BankAcc(name, accNo, type, balance);

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Display Details");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Calculate Interest");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    account.display();
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Withdraw Amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    account.checkBalance();
                    break;

                case 5:
                    account.showHistory();
                    break;

                case 6:
                    System.out.print("Enter Interest Rate (%): ");
                    double rate = sc.nextDouble();
                    account.calculateInterest(rate);
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }
}