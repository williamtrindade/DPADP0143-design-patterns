package io.github.williamtrindade.unity2.class7.exercise2.a.abstracts;

import io.github.williamtrindade.unity2.class7.exercise2.a.Movement;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private final Integer id;
    protected Double balance;
    private final boolean special;
    private final Type type;
    protected List<Movement> movements = new ArrayList<Movement>();

    public BankAccount(final Integer id, Double initialBalance, Type type, boolean special) {
        this.id = id;
        this.balance = initialBalance;
        this.type = type;
        this.special = special;
    }

    public Type getType() {
        return type;
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

    public List<Movement> getMovements() {
        return new ArrayList<Movement>(this.movements);
    }

    public Integer getId() {
        return id;
    }

    public abstract void addMovement(Movement movement) throws IllegalStateException;
}