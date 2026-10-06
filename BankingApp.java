import java.util.HashMap;
import java.util.Scanner;


class BankingApp{
    public static void main(String[] args) {
        final HashMap<Integer, BankAccount> accounts= new HashMap<>();
        Scanner sc= new Scanner(System.in);
        while(true)
        {
            System.out.println("welcome to banking operations, choose 0: create Account 1:deposit, 2:withdraw, 3:Balance 4:AccountInfo 5:TotalAccounts 6:Exit");
            int choice= sc.nextInt();
            if(choice==0)
            {
               System.out.println("enter ur name and opening balance");
               String customerName= sc.next();
               double openingAmount= sc.nextDouble();
               BankAccount acc= new BankAccount(customerName,openingAmount);
               int customerAccountNumber=acc.getAccountNumber();
               accounts.put(customerAccountNumber,acc);
               System.out.println("account created, your account number is: "+customerAccountNumber);
            }
            else if(choice==1)
            {
                System.out.println("enter the accountNumber");
                int number=sc.nextInt();
                BankAccount found=accounts.get(number);
                if(found==null)
                {
                  System.out.println("The following Account number does not exist");
                  continue;
                }
                System.out.println("enter the amount to be deposited");
                double depositAmount=sc.nextDouble();
                found.deposit(depositAmount);
            }
            else if(choice==2)
            {
                System.out.println("enter the accountNumber");
                int number= sc.nextInt();
                BankAccount found =accounts.get(number);
                if(found==null)
                {
                    System.out.println("the account number doesn't exist");
                    continue;
                }
                System.out.println("enter the amount to withdraw");
                double amountWithdraw=sc.nextDouble();
                found.withdraw(amountWithdraw);
            }
            else if(choice==3)
            {
                System.out.println("enter the accountNumber");
                int number=sc.nextInt();
                BankAccount found=accounts.get(number);
                if(found==null)
                {
                    System.out.println("doesn't exist");
                    continue;
                }
                double value=found.getBalance();
                System.out.println("the balance is: "+value);
            }
            else if(choice==4)
            {
                System.out.println("enter the accountNumber");
                int number=sc.nextInt();
                BankAccount found=accounts.get(number);
                if(found==null)
                {
                    System.out.println("doesn't exist");
                    continue;
                }
                found.AccountInfo();
            }
            else if(choice==5)
            {
                System.out.println("the total accounts are: "+ BankAccount.getTotalAccounts());
            }
            else if(choice==6)
            {
                System.out.println("Exiting the application");
                break;
            }
        }
        sc.close();
    }
}

class BankAccount{
    private final int accountNumber;
    private static int accountCounter=1000;
    private String accountName;
    private double balance;
    private static int totalAccounts;
    BankAccount(String accountName, double openingAmount)
    {
        this.accountNumber=accountCounter++;
        this.accountName=accountName;
        this.balance=openingAmount;
        totalAccounts++;
    }
    BankAccount()
    {
        this("defaultName",0);
    }
    int getAccountNumber()
    {
        return accountNumber;
    }
    void deposit(double amount)
    {
        this.balance+=amount;
    }
    void withdraw(double amount)
    {
        this.balance-=amount;
        System.out.println("Withdrawal is successful for the amount: "+amount);
        System.out.println("the new balance is: "+balance);
    }
    double getBalance()
    {
        return this.balance;
    }
    void AccountInfo()
    {
        System.out.println("Account Number: "+this.accountNumber);
        System.out.println("Balance: "+this.balance);
        System.out.println("AccountName:"+accountName);
    }
    static int getTotalAccounts(){
        return totalAccounts;
    }

}