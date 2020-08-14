package io.github.williamtrindade.unity1.class3.exercice4;

import io.github.williamtrindade.unity1.class3.exercice4.abstracts.BankAccount;
import io.github.williamtrindade.unity1.class3.exercice4.interfaces.IncomeAccountInterface;

public class FixedIncomeFund extends BankAccount implements IncomeAccountInterface {

    public FixedIncomeFund(Integer id, Double initialBalance, BankAccount.Type type, boolean special) {
        super(id, initialBalance, type, special);
    }

    @Override
    public Double getIRTax() {
        double irValue = 0.0;
        for (Movement movement: super.getMovements()) {
            irValue += movement.getValue() * 0.275;
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