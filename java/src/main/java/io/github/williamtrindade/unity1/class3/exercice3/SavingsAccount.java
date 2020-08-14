package io.github.williamtrindade.unity1.class3.exercice3;

import io.github.williamtrindade.unity1.class3.exercice3.abstracts.BankAccount;
import io.github.williamtrindade.unity1.class3.exercice3.interfaces.IncomeAccountInterface;
import io.github.williamtrindade.unity1.class3.exercice3.interfaces.NormalAccountInterface;

public class SavingsAccount extends BankAccount implements NormalAccountInterface, IncomeAccountInterface {
    
    private Double limit;

    SavingsAccount(Long id, Double initialBalance, BankAccount.Type type, boolean special) {
        super(id, initialBalance, type, special);
    }

    @Override
    public Double getLimit() {
        return limit;
    }

    @Override
    public void setLimit(Double limit) {
        this.limit = limit;
    }

    @Override
    public Double getIRTax() {
        double irValue = 0.0;
        for (Movement movement: super.getMovements()) {
            irValue += movement.getValue() * 0.05;
        }
        return irValue;
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
            case FINANCIAL_INCOME:
                this.balance += movement.getValue();
                break;
            default:
                throw new IllegalStateException("Incorrect movement type");
        }
        this.movements.add(movement);
    }

}