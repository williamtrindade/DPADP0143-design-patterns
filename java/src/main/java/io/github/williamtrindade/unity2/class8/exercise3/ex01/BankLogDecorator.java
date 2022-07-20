package io.github.williamtrindade.unity2.class8.exercise3.ex01;

import io.github.williamtrindade.unity2.class8.exercise3.ex01.bank.abstracts.BankAccount;
import io.github.williamtrindade.unity2.class8.exercise3.ex01.bank.interfaces.BankInterface;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

class BankLogDecorator implements BankInterface {
    private BankInterface decoratedBank;
    private Writer writerLog;


    public BankLogDecorator(BankInterface bank, String fileLogName) throws IOException {
        this.decoratedBank = bank;
        this.writerLog = new FileWriter(fileLogName);
    }

    @Override
    public boolean createAccount(Integer number, Double initialBalance, BankAccount.Type type) {
        return decoratedBank.createAccount(number, initialBalance, type);
    }

    @Override
    public BankAccount getAccount(Integer number) throws IllegalArgumentException {
        return decoratedBank.getAccount(number);
    }

    @Override
    public void deleteAccount(Integer number) {
        decoratedBank.deleteAccount(number);
    }

    @Override
    public void depositInAccount(Integer number, Double value) {
        decoratedBank.depositInAccount(number, value);
    }

    @Override
    public void withdraw(Integer number, Double value) {
        decoratedBank.withdraw(number, value);
    }

    @Override
    public void transferBetweenAccounts(Integer origin, Integer target, Double value) {
        decoratedBank.transferBetweenAccounts(origin, target, value);
    }

    @Override
    public HashMap<Integer, BankAccount> getAccounts() {
        return decoratedBank.getAccounts();
    }
}