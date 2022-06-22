package io.github.williamtrindade.unity2.class7.exercise2.d;

public class Test {
    public static void main(String[] args) {
        PrototypeFactory abstractFactory = new PrototypeFactory();
        BankAccount c = abstractFactory.create("William");
        System.out.println("\n" + c.toString());
    }
}
