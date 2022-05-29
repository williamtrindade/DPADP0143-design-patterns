package io.github.williamtrindade.unity2.class6.exercise2.b;

import io.github.williamtrindade.unity2.class6.exercise2.b.abstracts.BankAccount;

public interface BankInterface {
    // @Example(name = "Joao")
    boolean createAccount(Integer number, Double initialBalance, BankAccount.Type type);

    BankAccount getAccount(Integer number) throws IllegalArgumentException;

    void deleteAccount(Integer number);

    void depositInAccount(Integer number, Double value);

    void withdraw(Integer number, Double value);

    void transferBetweenAccounts(Integer origin, Integer target, Double value);
}
