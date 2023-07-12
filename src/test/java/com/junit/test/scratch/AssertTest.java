package com.junit.test.scratch;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.CoreMatchers.*;


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

    @Test
    void 증가된_잔금을_확인해요(){
        int 잔금초기화 = account.getBalance();
        account.deposit(50);
        assertThat(account.getBalance() > 잔금초기화, is(true));
    }

    @Test
    void an으로_시작하는_문자인지_확인해요(){
        assertThat(account.getName(), startsWith("an"));
    }

    @Test
    void 문자열_equalTo_실패케이스1(){
        assertThat(new String[]{"a","b","c"}, equalTo(new String[]{"a","b"}));
    }

    @Test
    void 문자열_equalTo_실패케이스2(){
        assertThat(new String[]{"a"}, equalTo(new String[]{"a","ab"}));
    }

    @Test
    void 문자열_equalTo_성공케이스1(){
        assertThat(new String[]{"a","b"}, equalTo(new String[]{"a","b"}));
    }

    @Test
    void 문자열_equalTo_성공케이스2(){
        assertThat(new String[]{"a"}, equalTo(new String[]{"a"}));
    }

    @Test
    void 문자열_is_eqaulTo_성공케이스(){
        assertThat(account.getName(), is(equalTo("an account name")));
    }

    @Test
    void 문자열_not_eqaulTo_성공케이스(){
        assertThat(account.getName(), not(equalTo("잘못된 문자")));
    }

    @Test
    void 문자열이_not_null(){
        assertThat(account.getName(), is(not(nullValue())));
        assertThat(account.getName(), is(notNullValue()));
    }
}
