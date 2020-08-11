package io.github.williamtrindade.class3.exercice5;

import io.github.williamtrindade.class3.exercice5.abstracts.BankAccount;

import java.util.Map;
import java.util.Random;

public class Test {

    public static void main(final String[] args) {
        final Bank nubank = new Bank();
        new Thread(new TesteBank(nubank)).start();
        new Thread(new TesteBank(nubank)).start();
        new Thread(new TesteBank(nubank)).start();
        new Thread(new TesteBank(nubank)).start();
    }

    static class TesteBank implements Runnable {

        private final Bank bank;
        private final long num = new Random().nextInt(100000);

        TesteBank(Bank bank) {
            this.bank = bank;
        }

        @Override
        public void run() {
            long millis = System.currentTimeMillis();
            testCreateNAccounts(bank, num);
            millis = System.currentTimeMillis() - millis;
            System.out.println("Tempo para criação de contas: " + millis + "ms. ");

            long millis2 = System.currentTimeMillis();
            testGetNAccounts(bank);
            millis2 = System.currentTimeMillis() - millis2;
            System.out.println("Tempo para percorrer de contas: " + millis2 + "ms. ");
        }

        public static void testCreateNAccounts(final Bank bank, long quantity) {
            for (long i=0; i<=quantity; i++) {
                bank.createAccount(i, 10.0, BankAccount.Type.CHECKING_ACCOUNT);
            }
        }

        public static void testGetNAccounts(final Bank bank) {
            for (Map.Entry<Long, BankAccount> entry : bank.getAccounts().entrySet()) {
                bank.getAccount(entry.getKey());
            }
        }
    }
}


