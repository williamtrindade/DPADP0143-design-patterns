package io.github.williamtrindade.unity2.class6.exercise2.c;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoolGenerico<T> implements Pool<T> {

    private Class<T> classe;
    private List<T> instanciasCriadas = new ArrayList<>(20);
    private List<T> instanciasDisponiveis = new ArrayList<>(20);

    private static Map<Class, Pool> INSTANCES = new HashMap<>();

    public static Pool getInstance(Class classe) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        synchronized (PoolGenerico.class) {
            if (INSTANCES.get(classe) == null) {
                INSTANCES.put(classe, new PoolGenerico(classe));
            }
        }
        return INSTANCES.get(classe);
    }

    private PoolGenerico(Class<T> classe)
            throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException
    {
        this.classe = classe;
        for (int i = 0; i < 3; i++) {
            T t = classe.getConstructor().newInstance();
            this.instanciasCriadas.add(t);
            this.instanciasDisponiveis.add(t);
        }
    }

    @Override
    public T acquire() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        synchronized (this) {
            if (!this.instanciasDisponiveis.isEmpty()) {
                T t = this.instanciasDisponiveis.remove(0);
                System.out.println("Entregou objeto " + t +
                        " para a thread " + Thread.currentThread().getId());
                return t;
            } else if (this.instanciasCriadas.size() < 20) {
                T t = classe.getConstructor().newInstance();
                this.instanciasCriadas.add(t);
                System.out.println("Entregou objeto " + t +
                        " para a thread " + Thread.currentThread().getId());
                return t;
            } else {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() + " dormiu.");
                    this.wait();
                    return this.instanciasDisponiveis.remove(0);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void release(T t) {
        synchronized (this) {
            if (this.instanciasCriadas.contains(t) && !this.instanciasDisponiveis.contains(t)) {
                this.instanciasDisponiveis.add(t);
                this.notify();
            } else {
                throw new IllegalArgumentException("objeto não pertence a este pool.");
            }
        }
    }
}
