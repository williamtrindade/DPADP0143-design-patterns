package io.github.williamtrindade.unity2.class7.d;

public class BankAccount implements Prototype<BankAccount> {

    private String owner;
    private final Integer id;
    protected Double balance;
    private final boolean special;
    private final Type type;

    public BankAccount(String owner, final Integer id, Double initialBalance, Type type, boolean special) {
        this.owner = owner;
        this.id = id;
        this.balance = initialBalance;
        this.type = type;
        this.special = special;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Type getType() {
        return type;
    }

    @Override
    public BankAccount clone() {
        return new BankAccount(this.owner, this.id, this.balance, this.type, this.special);
    }

    public enum Type {
        CHECKING_ACCOUNT, SAVINGS_ACCOUNT, FIXED_INCOME_FUND, VARIABLE_INCOME_FUND;
    }

    public boolean isSpecial() {
        return special;
    }

    public Double getBalance() {
        return balance;
    }

    public Integer getId() {
        return id;
    }

}