package class1.exercice2;

import java.util.ArrayList;
import java.util.List;

import class1.exercice2.abstracts.BankAccount;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    public void createAccount(Integer number, Double initialBalance, BankAccount.Type type) {
        BankAccount bankAccount = null;
        if (type == BankAccount.Type.CHECKING_ACCOUNT) {
            bankAccount = new CheckingAccount(number, initialBalance, false);
        } else if(type == BankAccount.Type.SAVINGS_ACCOUNT) {
            bankAccount = new SavingsAccount(number, initialBalance, false);
        } else if(type == BankAccount.Type.FIXED_INCOME_FUND) {
            bankAccount = new FixedIncomeFund(number, initialBalance, false);
        } else if(type == BankAccount.Type.VARIABLE_INCOME_FUND) {
            bankAccount = new VariableIncomeFund(number, initialBalance, false);
        }
        bankAccount.addMoveement(new Movement("Initial deposit", initialBalance, Movement.Type.CREDIT));
        this.accounts.add(bankAccount);
    }

    // public void setAccounts(List<BankAccount> accounts) {
    //     this.accounts = accounts;
    // }

    public void deleteAccount() {
        //
    }

    // public Double depositInAccount() {
    //     return null;
    // }

    // public Double getAccountBalance() {
    //     return null;
    // }

    // public Double getAccountStatement() {
    //     return null;
    // }

    // public void transferBetweenAccounts() {
       
    // }
}