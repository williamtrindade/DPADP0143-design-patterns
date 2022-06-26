package io.github.williamtrindade.unity2.class6.exercise2.c;

import java.lang.reflect.InvocationTargetException;

public interface Pool<T> {

    T acquire() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
    void release(T t);

}
