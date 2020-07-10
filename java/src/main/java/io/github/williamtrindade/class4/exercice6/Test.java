package io.github.williamtrindade.class4.exercice6;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        File file = FileService.getFile();
        assert file != null;
        URLClassLoader child = ClassLoaderService.pushToClassLoader(file);
        printClasses(child);
    }

    private static void printClasses(URLClassLoader child) throws ClassNotFoundException {
        List<Class<?>> classes = new ArrayList<>();
        classes.add(Class.forName("io.github.williamtrindade.class2.exercice2.Bank", true, child));
        classes.add(Class.forName("io.github.williamtrindade.class2.exercice2.Movement", true, child));
        classes.add(Class.forName("io.github.williamtrindade.class2.exercice2.SavingsAccount", true, child));

        for(Class<?> classe : classes){
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
