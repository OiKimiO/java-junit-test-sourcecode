package com.junit.test.scratch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class AssertTest {
    class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }

        private static final long serialVersionUID = 1L;
    }

    class Account{
        int balance;
        String name;

        Account(String name){
            this.name = name;
        }

        void deposit(int dollars){
            this.balance += dollars;
        }

        void withdraw(int dollars){
            if(this.balance < dollars){
                throw new InsufficientFundsException("balance only" + this.balance);
            }
            this.balance -= dollars;
        }

        public String getName(){
            return this.name;
        }

        public int getBalance(){
            return this.balance;
        }

        public boolean hasPositiveBalance(){
            return balance > 0;
        }
    }

    class Customer{
        List<Account> accounts = new ArrayList<>();

        void add(Account account){
            accounts.add(account);
        }

        Iterator<Account> getAccounts(){
            return accounts.iterator();
        }
    }

    private Account account;

    @BeforeEach
    public void createAccount(){
        account = new Account("an account name");
    }

    @Test
    void 잔금이_남아있어요(){
        account.deposit(50);
        assertTrue(account.hasPositiveBalance());
    }
}
