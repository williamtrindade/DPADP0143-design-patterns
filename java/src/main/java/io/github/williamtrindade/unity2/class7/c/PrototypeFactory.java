package io.github.williamtrindade.unity2.class7.c;

public class PrototypeFactory {

    private final Prototype<BankAccount> bankAccountPrototype;

    public PrototypeFactory() {
        this.bankAccountPrototype = new BankAccount(null, 1, 0.0, null, false);
    }

    public BankAccount create(int id, double balance) {
        BankAccount bankAccount = bankAccountPrototype.clone();
        bankAccount.setOwner("William");
        return bankAccount;
    }
}
