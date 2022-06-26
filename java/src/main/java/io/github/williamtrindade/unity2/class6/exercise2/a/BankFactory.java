package io.github.williamtrindade.unity2.class6.exercise2.a;

import io.github.williamtrindade.unity2.class6.exercise2.a.bank.*;
import io.github.williamtrindade.unity2.class6.exercise2.a.bank.abstracts.*;

public class BankFactory {
    public BankAccount createAccount(BankAccount.Type type) {
        if (type == BankAccount.Type.CHECKING_ACCOUNT) {
            return new CheckingAccount(1, 200.0, type, false);
        } else if (type == BankAccount.Type.FIXED_INCOME_FUND) {
            return new FixedIncomeFund(1, 200.0, type, false);
        } else if (type == BankAccount.Type.VARIABLE_INCOME_FUND) {
            return new VariableIncomeFund(1, 200.0, type, false);
        } else if (type == BankAccount.Type.SAVINGS_ACCOUNT) {
            return new SavingsAccount(1, 200.0, type, false);
        }
        return null;
    }
}
