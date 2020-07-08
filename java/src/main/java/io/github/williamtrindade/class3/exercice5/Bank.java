package io.github.williamtrindade.class3.exercice5;

import io.github.williamtrindade.class3.exercice5.abstracts.BankAccount;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {

    private final Map<Long, BankAccount> accounts = new ConcurrentHashMap<>();

    public void createAccount(Long number, Double initialBalance, BankAccount.Type type) {
        BankAccount bankAccount = this.getAccount(number);
        if (bankAccount == null) {
            if (type == BankAccount.Type.CHECKING_ACCOUNT) {
                bankAccount = new CheckingAccount(number, initialBalance, type, false);
            } else if (type == BankAccount.Type.SAVINGS_ACCOUNT) {
                bankAccount = new SavingsAccount(number, initialBalance, type, false);
            } else if (type == BankAccount.Type.FIXED_INCOME_FUND) {
                bankAccount = new FixedIncomeFund(number, initialBalance, type, false);
            } else if (type == BankAccount.Type.VARIABLE_INCOME_FUND) {
                bankAccount = new VariableIncomeFund(number, initialBalance, type, false);
            }
            try {
                assert bankAccount != null;
                bankAccount.addMovement(new Movement("Initial deposit", initialBalance, Movement.Type.CREDIT));
            } catch (NullPointerException e) {
                return;
            }
            this.accounts.put(bankAccount.getId(), bankAccount);
        }
    }

    public Map<Long, BankAccount> getAccounts() {
        return this.accounts;
    }

    public BankAccount getAccount(Long number) {
        return this.accounts.get(number);
    }

    public void deleteAccount(Long number) {
        this.accounts.remove(number);
    }

    public void depositInAccount(Long number, Double value) {
        BankAccount bankAccount = this.getAccount(number);
        try {
            bankAccount.addMovement(new Movement("Deposit", value, Movement.Type.CREDIT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(Long number, Double value) {
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

    public void transferBetweenAccounts(Long origin, Long target, Double value) {
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