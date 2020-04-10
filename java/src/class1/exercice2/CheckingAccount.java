package class1.exercice2;

import class1.exercice2.abstracts.BankAccount;
import class1.exercice2.interfaces.NormalAccountaInterface;

public class CheckingAccount extends BankAccount implements NormalAccountaInterface {

    private Double limit;

    CheckingAccount(Integer id, Double initialBalance, boolean special) {
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
}