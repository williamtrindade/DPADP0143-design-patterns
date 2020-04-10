package class1.exercice2;

import class1.exercice2.abstracts.BankAccount;
import class1.exercice2.interfaces.IncomeAccountInterface;

public class VariableIncomeFund extends BankAccount implements IncomeAccountInterface {

    public VariableIncomeFund(Integer id, Double initialBalance, boolean special) {
        super(id, initialBalance, special);
    }

    @Override
    public Double getIRTax() {
        Double irValue = 0.0;
        for (Movement movement: super.getMovements()) {
            irValue += movement.getValue() * 0.275;
        }
        return irValue;
    }

}