package io.github.williamtrindade.unity2.class7.d;

public class PrototypeFactory {
    private final Prototype<BankAccount> bankAccountPrototype;

    public PrototypeFactory() {
        this.bankAccountPrototype = new BankAccount(
                null,
                1,
                0.0,
                null,
                false
        );
    }

    public BankAccount create(String ownerName) {
        BankAccount bankAccount = bankAccountPrototype.clone();
        bankAccount.setOwner(ownerName);
        return bankAccount;
    }
}
