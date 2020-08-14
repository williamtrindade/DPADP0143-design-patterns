package io.github.williamtrindade.unity1.class4.exercise6;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        File file = FileService.getFile();
        assert file != null;
        URLClassLoader child = ClassLoaderService.pushToClassLoader(file);
       // printClasses(child);
        testBank(child);
    }

    private static void testBank(URLClassLoader child) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> classe = Class.forName("io.github.williamtrindade.class2.exercise2.Bank", true, child);
        Class accountType;
        accountType = Class.forName("io.github.williamtrindade.class2.exercise2.abstracts.BankAccount$Type", true, child);

        Object bankInstance = classe
                .getConstructor()
                .newInstance();

        Method createAccount = classe.getDeclaredMethod("createAccount", Integer.class, Double.class, accountType);
        try {
            createAccount.invoke(
                    bankInstance,
                    1,
                    100.0,
                    Enum.valueOf(accountType,"CHECKING_ACCOUNT")
            );
        } catch (InvocationTargetException e) {
            System.out.println("Erro ao invocar método");
        }
        // criarConta.invoke(bancoInstance,1, true, 1000, Enum.valueOf(meuEnum, "RENDA_FIXA") );
       // System.out.println(accountCreated);
    }


    private static void printClasses(URLClassLoader child) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        classes.add(Class.forName("io.github.williamtrindade.class2.exercise2.Bank", true, child));
        classes.add(Class.forName("io.github.williamtrindade.class2.exercise2.Movement", true, child));
        classes.add(Class.forName("io.github.williamtrindade.class2.exercise2.SavingsAccount", true, child));

        for(Class<?> classe : classes) {
            System.out.println(classe.getName() + ":");

            System.out.println("Atributos: ");
            for (Field mfield : classe.getDeclaredFields()) System.out.println(mfield.getName() + ": " + mfield.getType());
            System.out.println();

            System.out.println("Métodos: ");
            for(Method mmethod : classe.getDeclaredMethods()) System.out.println(mmethod.getName());
            System.out.println();
        }
    }
}
