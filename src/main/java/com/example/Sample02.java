package com.example;

import java.util.ArrayList;
import java.util.List;

public class Sample02 extends Sample01{
    public static void printTest(){
        System.out.println("test3");
    }

    public void main(String[] args) {
        Account[] accountArray = new Account[10];
        int i = 10;
        for (int j = 0; j < i; j++) {
            Account account = new Account();
            account.id = i;
            account.balance = 100;
            accountArray[j] = account;
        }

    }

    public  class Account {
        private int id;
        private int balance;
    }
}
