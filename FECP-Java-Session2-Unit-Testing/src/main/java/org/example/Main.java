package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice = 0;

        ArrayList<BankAccount> BankSystem = new ArrayList<>();
        String accountNumber;
        String accountHolderName;

        int initialDeposit;
        int amountToDeposit;
        int amountToWithdraw;

        while (userChoice != 6){
            System.out.println("=== Bank Menu ===");
            System.out.println("1. Create Account");
            System.out.println("2. View All Accounts");
            System.out.println("3. Check Balance");
            System.out.println("4. Deposit");
            System.out.println("5. Withdraw");
            System.out.println("6. Exit");
            System.out.print("Enter choice (1-5): ");

            userChoice = scanner.nextInt();
            switch(userChoice){
                // create an account
                case 1:
                    System.out.print("\nEnter Account Number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter Account Holder Name: ");
                    accountHolderName = scanner.next();

                    System.out.print("Initial deposit? (yes/no): ");
                    boolean hasInitialDeposit = Objects.equals(scanner.next(), "yes");

                    if (hasInitialDeposit) {
                        System.out.print("Enter Initial Deposit Amount: ");
                        initialDeposit = scanner.nextInt();
                    } else {
                        initialDeposit = 0;
                    }

                    if (initialDeposit < 0) {
                        System.out.println("Invalid amount to deposit.\n");
                        break;
                    }

                    BankSystem.add(new BankAccount(accountNumber, accountHolderName, initialDeposit));
                    System.out.println("Account created successfully!\n");

                    break;

                // view all accounts
                case 2:
                    System.out.println("\n--- Account Information ---");

                    for (BankAccount account : BankSystem){
                        account.displayInformation();
                    }

                    break;

                // check balance
                case 3:
                    System.out.print("\nEnter Account Number: ");
                    accountNumber = scanner.next();

                    for (BankAccount account : BankSystem){
                        if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                            System.out.printf("Current Available Balance for Account Number %s: %d\n\n", accountNumber, account.getAvailableBalance());
                        }
                    }

                    break;

                // deposit
                case 4:
                    System.out.print("\nEnter Amount to Deposit: ");
                    amountToDeposit = scanner.nextInt();

                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.next();

                    for (BankAccount account : BankSystem){
                        if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                            account.deposit(amountToDeposit);
                            System.out.printf("Current Available Balance: %d\n\n", account.getAvailableBalance());
                        }
                    }

                    break;

                // withdraw
                case 5:
                    System.out.print("\nEnter Amount to Withdraw: ");
                    amountToWithdraw = scanner.nextInt();

                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.next();

                    for (BankAccount account : BankSystem){
                        if (Objects.equals(account.getAccountNumber(), accountNumber)) {
                            account.withdraw(amountToWithdraw);
                            System.out.printf("Current Available Balance: %d\n\n", account.getAvailableBalance());
                        }
                    }

                    break;

                // exit
                case 6:
                    break;
            }
        }

        System.out.println("\n--- Thank you! ---");
    }
}