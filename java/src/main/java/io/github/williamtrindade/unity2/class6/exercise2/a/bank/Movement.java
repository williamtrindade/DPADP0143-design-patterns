package io.github.williamtrindade.unity2.class6.exercise2.a.bank;

public class Movement {
    private final String description;
    private final Double value;
    private final Type type;

    public Movement(String description, Double value, Type type) {
        this.description = description;
        this.value = value;
        this.type = type;
    }

    public enum Type {
        CREDIT, DEBIT, FINANCIAL_INCOME;
    }

    public Type getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public Double getValue() {
        return value;
    }
}