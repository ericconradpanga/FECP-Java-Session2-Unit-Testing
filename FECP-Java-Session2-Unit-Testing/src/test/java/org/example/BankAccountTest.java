package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankAccountTest {
    private BankAccount testAccount;

    @BeforeEach
    void setup() {
        testAccount = new BankAccount("000", "Test", 1000);
    }

    @Test
    void shouldSuccessfullyDepositIfValidAmount() {
        testAccount.deposit(500);
        int expected = 1500;
        int actual = testAccount.getAvailableBalance();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotBeAbleToDepositIfInvalidAmount() {
        testAccount.deposit(-500);
        int expected = 1000;
        int actual = testAccount.getAvailableBalance();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSuccessfullyWithdrawIfValidAmount() {
        testAccount.withdraw(500);
        int expected = 500;
        int actual = testAccount.getAvailableBalance();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotBeAbleToWithdrawIfInvalidAmount() {
        testAccount.withdraw(-500);
        int expected = 1000;
        int actual = testAccount.getAvailableBalance();

        assertEquals(expected, actual);
    }

    @Test
    void shouldNotBeAbleToWithdrawIfAmountExceedsBalance() {
        testAccount.withdraw(1500);
        int expected = 1000;
        int actual = testAccount.getAvailableBalance();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSuccessfullyGetAccountNumber() {
        String expected = "000";
        String actual = testAccount.getAccountNumber();

        assertEquals(expected, actual);
    }

    @Test
    void shouldSuccessfullyCreateAccountWithoutDeposits() {
        BankAccount testAccount2 = new BankAccount("001", "Test Account 2", 0);
        String expected = "001, Test Account 2, 0";
        String actual = testAccount2.getAccountNumber() + ", " + testAccount2.getAccountHolderName() + ", " + testAccount2.getAvailableBalance();

        assertEquals(expected, actual);
    }
}