package io.github.williamtrindade.unity1.class5.exercise8.ex2;

import io.github.williamtrindade.unity1.class5.exercise8.ex2.abstracts.BankAccount;
import io.github.williamtrindade.unity1.class5.exercise8.ex2.interfaces.IncomeAccountInterface;

public class VariableIncomeFund extends BankAccount implements IncomeAccountInterface {

    public VariableIncomeFund(Integer id, Double initialBalance, BankAccount.Type type, boolean special) {
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
            case FINANCIAL_INCOME:
                this.balance += movement.getValue();
                break;
            case DEBIT:
                this.balance -= movement.getValue();
                break;
            default:
                throw new IllegalStateException("Incorrect movement type");
        }
        this.movements.add(movement);
    }
    
}