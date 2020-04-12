package class2.exercice3;

import java.util.HashMap;
import class2.exercice3.abstracts.BankAccount;

public class Bank {

    private HashMap<Integer, BankAccount> accounts = new HashMap<>();

    public boolean createAccount(Integer number, Double initialBalance, BankAccount.Type type) {
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
                bankAccount.addMovement(new Movement("Initial deposit", initialBalance, Movement.Type.CREDIT));
            } catch (Exception e) {
                return false;
            }
            this.accounts.put(bankAccount.getId(), bankAccount);
            return true;
        }
        return false;
    }

    public HashMap<Integer, BankAccount> getAccounts() {
        return this.accounts;
    }

    public BankAccount getAccount(Integer number) {
        return this.accounts.get(number);
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