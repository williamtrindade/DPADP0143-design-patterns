package io.github.williamtrindade.unity2.class6.exercise2.c;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenericPool<T> implements Pool<T> {

    private final Class<T> classe;
    private final List<T> allowedInstances = new ArrayList<>(20);
    private final List<T> createdInstances = new ArrayList<>(20);

    private static Map<Class, Pool> INSTANCES = new HashMap<>();

    public Pool<T> getInstance(Class classe) throws
            InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException
    {
        synchronized (GenericPool.class) {
            if (INSTANCES.get(classe) == NULL) {
                INSTANCES = new GenericPool<T>(classe);
            }
        }
        return INSTANCES.get(classe);
    }

    public GenericPool(Class<T> classe) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        this.classe = classe;
        for (int i = 0; i < 3; i++) {
            T o = classe.getDeclaredConstructor().newInstance();
            allowedInstances.add(o);
            createdInstances.add(o);
        }
    }

    @Override
    public T acquire() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException {
        synchronized (allowedInstances) {
            if (!allowedInstances.isEmpty()) {
                return allowedInstances.remove(0);
            } else if (allowedInstances.size() < 20) {
                T o = classe.getDeclaredConstructor().newInstance();
                createdInstances.add(o);
                return o;
            } else {
                allowedInstances.wait();
                return allowedInstances.remove(0);
            }
        }
    }

    @Override
    public void release(T o) {
        synchronized (allowedInstances) {
            if (!allowedInstances.contains(o)) {
                return;
            }
            allowedInstances.add(o);
            if (allowedInstances.size() == 1) {
                allowedInstances.notify();
            }
        }
    }
}
