package class1.exercice2;

import class1.exercice2.abstracts.BankAccount;
import class1.exercice2.interfaces.IncomeAccountInterface;
import class1.exercice2.interfaces.NormalAccountaInterface;

public class SavingsAccount extends BankAccount implements NormalAccountaInterface, IncomeAccountInterface {
    private Double limit;

    SavingsAccount(Integer id, Double initialBalance, boolean special) {
        super(id, initialBalance, special);
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
        Double irValue = 0.0;
        for (Movement movement: super.getMovements()) {
            irValue += movement.getValue() * 0.005;
        }
        return irValue;
    }
}