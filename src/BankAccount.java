import java.util.Scanner;
import java.util.Random;

public class BankAccount {
    Scanner scanner = new Scanner(System.in);
    Random createAccountNum = new Random();
    
    double accountBalance;
    String name;
    int accountNumber;

    public BankAccount(double accountBalance, String name, int accountNumber){
        this.accountBalance = accountBalance;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    //Bank account constructor with no parameters: Creates new customer from customer input 
    public BankAccount(){}

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void transfer(BankAccount acc, double amount) {
        withdrawal(amount);
        acc.deposit(amount);
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double deposit(double depositAmount){
        double balanceAfterDeposit = (this.accountBalance + depositAmount);
        this.accountBalance = balanceAfterDeposit;
        return balanceAfterDeposit;
    }

    public double withdrawal(double withdrawlAmount){
        double balanceAfterWithdrawl = (this.accountBalance - withdrawlAmount);
        this.accountBalance = balanceAfterWithdrawl;
        return balanceAfterWithdrawl;
    }

    public void accountDetails(){

        System.out.println("Account holder: " + this.name );
        System.out.println("Current account balance: " + this.accountBalance );
        System.out.println("Account number: " + this.accountNumber);
    }

    @Override
    public String toString() {
        return ("\n" + "Account holder: " + this.name) + (", Current account balance: " + this.accountBalance ) + (", Account number: " + this.accountNumber );
    }

}
