package io.github.williamtrindade.unity2.class6.exercise2.b;

import io.github.williamtrindade.unity2.class6.exercise2.b.abstracts.BankAccount;

import java.util.HashMap;

public class Bank implements BankInterface {
    private final HashMap<Integer, BankAccount> accounts = new HashMap<>();

    private static BankInterface INSTANCE;
    
    private Bank() { }
    
    public static BankInterface getInstance() {
        synchronized (Bank.class) {
            if (INSTANCE == null) {
                INSTANCE = new Bank();
            }
        }
        return INSTANCE;
    }
    
    // @Example(name = "Joao")
    @Override
    public boolean createAccount(Integer number, Double initialBalance, BankAccount.Type type) {
        BankAccount bankAccount = this.getAccount(number);
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
            bankAccount.addMovement(new Movement("Initial deposit", initialBalance, Movement.Type.CREDIT));
        } catch (Exception e) {
            return false;
        }
        this.accounts.put(bankAccount.getId(), bankAccount);
        return true;
    }

    @Override
    public BankAccount getAccount(Integer number) throws IllegalArgumentException {
        BankAccount bankAccount = this.accounts.get(number);
        if (bankAccount == null) {
            throw new IllegalArgumentException();
        }
        return bankAccount;
    }

    @Override
    public void deleteAccount(Integer number) {
        this.accounts.remove(number);
    }

    @Override
    public void depositInAccount(Integer number, Double value) {
        BankAccount bankAccount = this.getAccount(number);
        try {
            bankAccount.addMovement(new Movement("Deposit", value, Movement.Type.CREDIT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
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

    @Override
    public void transferBetweenAccounts(Integer origin, Integer target, Double value) {
        BankAccount originBankAccount = this.getAccount(origin);
        BankAccount targetBankAccount = this.getAccount(target);
        // Debit and Credit
        try {
            originBankAccount.addMovement(new Movement("Successfully money transference ", value, Movement.Type.DEBIT));
            targetBankAccount.addMovement(new Movement("Successfully money transference", value, Movement.Type.CREDIT));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}