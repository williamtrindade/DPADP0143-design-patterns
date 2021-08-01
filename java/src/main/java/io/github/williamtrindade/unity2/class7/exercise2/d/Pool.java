package io.github.williamtrindade.unity2.class7.exercise2.d;

import java.lang.reflect.InvocationTargetException;

public interface Pool<T> {
    T acquire() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InterruptedException;
    void release(T t);
}
