package io.github.williamtrindade.unity2.class6.exercise2.b;

public class Singleton {

    private static Singleton INSTANCE;

    private Singleton() { }

    public static Singleton getInstance() {
        synchronized (Singleton.class) {
            if (INSTANCE == null) {
                INSTANCE = new Singleton();
            }
        }
        return INSTANCE;
    }

}