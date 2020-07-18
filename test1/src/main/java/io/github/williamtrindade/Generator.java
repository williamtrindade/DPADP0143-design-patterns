package io.github.williamtrindade;

import io.github.williamtrindade.annotations.Field;
import io.github.williamtrindade.services.html.ContentService;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author William Trindade<williamtrindade777@gmail.com>
 */
public enum Generator implements FormGenerator {
    GENERATOR;

    @Override
    public String generateForm(Object object) {
        ContentService contentService = new ContentService(object);
        return contentService.generateHTML(false);
    }

    @Override
    public String generateReadOnlyView(Object object) {
        ContentService contentService = new ContentService(object);
        return contentService.generateHTML(true);
    }

    @Override
    public Object populateObject(Map<String, String> requestParams, Class<?> objClass) {
        if (requestParams != null && objClass != null) {
            try {
                Constructor<?> objectConstructor = objClass.getConstructor();
                Object object = objectConstructor.newInstance();
                for (Method method : objClass.getDeclaredMethods()) {
                    if (method.getAnnotation(Field.class) != null) {
                        String name = method.getAnnotation(Field.class).name();
                        if (requestParams.containsKey(name)) {
                            this.callSetMethod(objClass, object, method, requestParams.get(name));
                        }
                    }
                }
                return object;
            } catch (
                    NoSuchMethodException
                    | IllegalAccessException
                    | InstantiationException
                    | InvocationTargetException e
            ) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private void callSetMethod(
            Class<?> objectClass,
            Object object,
            Method methodToInvoke,
            String valueToSet
    ) {
        String methodName = methodToInvoke.getName().replaceFirst("is|get", "set");
        try {
            Method method = objectClass.getDeclaredMethod(methodName, methodToInvoke.getReturnType());
            if (methodToInvoke.getReturnType().isAssignableFrom(boolean.class)) {
                method.invoke(object, Boolean.parseBoolean(valueToSet));
            } else if (methodToInvoke.getReturnType().isAssignableFrom(Long.class)) {
                method.invoke(object, Long.parseLong(valueToSet));
            } else {
                method.invoke(object, valueToSet);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
