package com.junit.test.scratch;

public class AssertTest {
    class InsufficientFundsException extends RuntimeException {
        public InsufficientFundsException(String message) {
            super(message);
        }
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


}
