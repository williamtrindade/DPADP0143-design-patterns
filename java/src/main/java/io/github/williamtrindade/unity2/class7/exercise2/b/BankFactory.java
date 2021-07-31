package io.github.williamtrindade.unity2.class7.exercise2.b;

public class BankFactory {

    private static BankFactory INSTANCE;

    public static BankFactory getInstance() {
        synchronized (BankFactory.class) {
            if (INSTANCE == null) {
                INSTANCE = new BankFactory();
            }
        }
        return INSTANCE;
    }

    private BankFactory() { }

    public BankInterface createBankInstance() {
        // Regras para decidir qual banco será instanciado
        return new Bank();
    }

}
