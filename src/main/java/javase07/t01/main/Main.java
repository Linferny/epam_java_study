package javase07.t01.main;

import javase07.t01.logic.Bank;
import javase07.t01.logic.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Bank");

        bank.parseLogs("logs.txt");
    }
}
