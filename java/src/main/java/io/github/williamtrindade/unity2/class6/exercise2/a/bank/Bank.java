package io.github.williamtrindade.unity2.class6.exercise2.a.bank;

import io.github.williamtrindade.unity2.class6.exercise2.a.bank.abstracts.BankAccount;

import java.util.HashMap;

public class Bank {

    private final HashMap<Integer, BankAccount> accounts = new HashMap<>();

    // @Example(name = "Joao")
    public boolean insertAccount(BankAccount account) {
        try {
            account.addMovement(new Movement("Initial deposit", 0.0, Movement.Type.CREDIT));
        } catch (Exception e) {
            return false;
        }
        this.accounts.put(account.getId(), account);
        return true;
    }

    public BankAccount getAccount(Integer number) throws IllegalArgumentException {
        BankAccount bankAccount = this.accounts.get(number);
        if (bankAccount == null) {
            throw new IllegalArgumentException();
        }
        return bankAccount;
    }

    public void deleteAccount(Integer number) {
        this.accounts.remove(number);
    }

    public void depositInAccount(Integer number, Double value) {
        BankAccount bankAccount = this.getAccount(number);
        try {
            bankAccount.addMovement(new Movement("Deposit", value, Movement.Type.CREDIT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(Integer number, Double value) {
        BankAccount bankAccount = this.getAccount(number);
        try {
            bankAccount.addMovement(new Movement("withdraw money", value, Movement.Type.DEBIT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // public Double getAccountBalance() {
    //     return null;
    // }

    // public Double getAccountStatement() {
    //     return null;
    // }

    public void transferBetweenAccounts(Integer origin, Integer target, Double value) {
        BankAccount originBankAccount = this.getAccount(origin);
        BankAccount targetBankAccount = this.getAccount(target);
        // Debit and Credit
        try {
            originBankAccount.addMovement(new Movement("Successfully money tranference ", value, Movement.Type.DEBIT));
            targetBankAccount.addMovement(new Movement("Successfully money tranference", value, Movement.Type.CREDIT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}