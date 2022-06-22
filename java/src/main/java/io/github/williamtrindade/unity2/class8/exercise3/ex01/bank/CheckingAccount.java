package io.github.williamtrindade.unity2.class8.exercise3.ex01.bank;

import io.github.williamtrindade.unity2.class8.exercise3.ex01.bank.abstracts.BankAccount;
import io.github.williamtrindade.unity2.class8.exercise3.ex01.bank.interfaces.NormalAccountInterface;

public class CheckingAccount extends BankAccount implements NormalAccountInterface {

    private Double limit;

    public CheckingAccount(Integer id, Double initialBalance, Type type, boolean special) {
        super(id, initialBalance, type, special);
    }

    @Override
    public Double getLimit() {
        return limit + super.getBalance();
    }

    @Override
    public void setLimit(Double limit) {
        this.limit = limit;
    }

    @Override
    public void addMovement(Movement movement) throws IllegalStateException {
        switch(movement.getType()) {
            case CREDIT: 
                this.balance += movement.getValue();
                break;
            case DEBIT:
                if (movement.getValue() > this.getLimit()) {
                    throw new IllegalStateException("Value exced the limit");
                }
                this.balance -= movement.getValue();
                break;
            default:
                throw new IllegalStateException("Incorrect movement type");
        }
        this.movements.add(movement);
    }
    
}