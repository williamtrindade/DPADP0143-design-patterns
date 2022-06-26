package io.github.williamtrindade.unity2.class6.exercise2.a;
import io.github.williamtrindade.unity2.class6.exercise2.a.bank.Bank;
import io.github.williamtrindade.unity2.class6.exercise2.a.bank.abstracts.BankAccount;

public class Main {
    public static void main(String[] args) {
        Bank c6Bank = new Bank();

        BankFactory bankfactory = new BankFactory();
        BankAccount c6Account = bankfactory.createAccount(BankAccount.Type.SAVINGS_ACCOUNT);

        if (c6Bank.insertAccount(c6Account))    {
            System.out.println("Conta criada com sucesso: "+c6Account.getId());
        }
    }
}
