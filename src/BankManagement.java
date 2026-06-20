import java.util.Scanner;

class BankAcc
{
    String accountHolder;
    int accountNumber;
    double balance;

    BankAcc(String accountHolder,int accountNumber,double balance)
    {
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }
    void deposit(double amount)
    {
        balance+=amount;
        System.out.println("₹"+ amount + "Deposited Successfully.");
    }
    void withdraw(double amount)
    {
        if(amount<=balance)
        {
            balance-=amount;
            System.out.println("₹" + amount + "Withdraw Successfully.");
        }
        else {
            System.out.println("Insufficient Balance.");
        }
    }
    void display()
    {
        System.out.println("--------Account Details---------");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}
public class BankManagement
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter Account Holder Name:");
        String AccName = sc.nextLine();
        System.out.println("Enter Account Number:");
        int AccNo = sc.nextInt();
        System.out.println("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        BankAcc account=new BankAcc( AccName,AccNo,balance);
        int choice;
        do
        {
            System.out.println("-----Bank Menu------");
            System.out.println("1. Account Details");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");
            choice=sc.nextInt();
            switch (choice)
            {
                case 1:
                    account.display();
                    break;

                case 2:
                    System.out.println("Enter Amount to Deposit");
                    double depositAmount=sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Enter Amount to Withdraw");
                    double withdrawAmount=sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank Youu.......!");

                default:
                    System.out.println("Invalid Choice");
            }
        }
        while(choice!=4);
        sc.close();
    }
}
