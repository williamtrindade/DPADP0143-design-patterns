package io.github.williamtrindade.unity2.class8.exercise3.ex01.bank.interfaces;

import io.github.williamtrindade.unity2.class8.exercise3.ex01.bank.abstracts.BankAccount;

public interface BankInterface {
    public boolean createAccount(Integer number, Double initialBalance, BankAccount.Type type);
    public BankAccount getAccount(Integer number) throws IllegalArgumentException;
    public void deleteAccount(Integer number);
    public void depositInAccount(Integer number, Double value);
    public void withdraw(Integer number, Double value);
    public void transferBetweenAccounts(Integer origin, Integer target, Double value);
}
