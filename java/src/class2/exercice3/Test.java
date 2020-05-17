package class2.exercice3;

import class2.exercice3.abstracts.BankAccount;
import java.util.Map;

public class Test {

    public static void main(final String[] args) {
        final Bank nubank = new Bank();

        long millis = System.currentTimeMillis();
        testCreateNAccounts(nubank, 100000);
        millis = System.currentTimeMillis() - millis;
        System.out.println("Tempo para criação de contas: " + millis + "ms. ");

        long millis2 = System.currentTimeMillis();
        testGetNAccounts(nubank);
        millis2 = System.currentTimeMillis() - millis2;
        System.out.println("Tempo para percorrer de contas: " + millis2 + "ms. ");

    }

    public static void testCreateNAccounts(final Bank bank, long quantity) {
        long i = 0;
        for (i=0; i<=quantity; i++) {
            bank.createAccount(i, 10.0, BankAccount.Type.CHECKING_ACCOUNT);
        }
    }

    public static void testGetNAccounts(final Bank bank) {
        for (Map.Entry<Long, BankAccount> entry : bank.getAccounts().entrySet()) {
            bank.getAccount(entry.getKey());
        }
    }
}