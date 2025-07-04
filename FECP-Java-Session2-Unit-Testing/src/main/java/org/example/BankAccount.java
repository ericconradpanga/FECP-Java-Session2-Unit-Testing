package org.example;

public class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private int availableBalance;

    // constructor for a bank account
    public BankAccount(String accountNumber, String accountHolderName, int availableBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.availableBalance = availableBalance;
    }

    // setter for depositing amount to a bank account
    public void deposit(int amountToDeposit){
        if (amountToDeposit < 0) {
            System.out.println("Invalid amount to deposit.");
        } else {
            this.availableBalance += amountToDeposit;
            System.out.println("Amount deposited successfully!");
        }
    }

    // setter for withdrawing amount to a bank account
    public void withdraw(int amountToWithdraw){
        if (amountToWithdraw < 0 || amountToWithdraw > this.availableBalance) {
            System.out.println("Invalid amount to withdraw.");
        } else {
            this.availableBalance -= amountToWithdraw;
            System.out.println("Amount withdrawn successfully!");
        }
    }

    // method to display account information
    public void displayInformation(){
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder Name: " + this.accountHolderName);
        System.out.println("Available Balance: " + this.availableBalance + "\n");
    }

    // getter to retrieve bank account number
    public String getAccountNumber() {
        return this.accountNumber;
    }

    // getter to retrieve bank account holder name
    public String getAccountHolderName() { return this.accountHolderName; }

    // getter to retrieve bank available balance
    public int getAvailableBalance() {
        return this.availableBalance;
    }
}
