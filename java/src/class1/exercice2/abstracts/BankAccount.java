package class1.exercice2.abstracts;

import java.util.ArrayList;
import java.util.List;
import class1.exercice2.Movement;

public abstract class BankAccount {
    private final Integer id;
    private Double balance;
    private final boolean special;
    private List<Movement> movements = new ArrayList<Movement>();

    public BankAccount(final Integer id, Double initialBalance, boolean special) {
        this.id = id;
        this.balance = initialBalance;
        this.special = special;
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
        List<Movement> movementsCopy = new ArrayList<Movement>(this.movements);
        return movementsCopy;
    }

    public Integer getId() {
        return id;
    }

    public void addMoveement(Movement movement) {
        this.movements.add(movement);
        this.incrementBalance(movement.getValue());
    }

    private void incrementBalance(Double value) {
        this.balance += value;
    }
}