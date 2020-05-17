package class2.exercice4;

import class2.exercice4.abstracts.BankAccount;

public class Test {
    public static void main(final String[] args) {
        final Bank bradesco = new Bank();
        // Bank nubank = new Bank();
        testCreateNAccounts(bradesco, 10000);
    }
    public static void testCreateNAccounts(final Bank bank, int quantity) {
        int i = 0;
        for (i=0; i<=quantity; i++) {
            bank.createAccount(i, 10.0, BankAccount.Type.CHECKING_ACCOUNT);
            System.out.println( i +" | Iteração :" + bank.getAccounts());
            System.out.println("----------------------------------------");
        }
    }
}