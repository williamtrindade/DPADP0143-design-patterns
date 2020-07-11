package io.github.williamtrindade.class4.exercice7;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonFramework {

    public String generateJson(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> mclass = object.getClass();
        StringBuffer sb = new StringBuffer();
        sb.append("{\n");
        boolean first = true;
        for (Method mmethod : mclass.getMethods()) {
            if (( mmethod.getName().startsWith("get") || mmethod.getName().startsWith("is") )&& mmethod.getAnnotation(Json.class) != null) {
                if (!first) {
                    sb.append(",\n");
                }
                String name;

                // Att name
                if ( mmethod.getName().startsWith("get")) {
                    name = "\"" + mmethod.getName().substring(3, 4).toLowerCase() + mmethod.getName().substring(4) +  "\"";
                } else {
                    name = "\"" + mmethod.getName().substring(2, 3).toLowerCase() + mmethod.getName().substring(3) +  "\"" ;
                }
                sb.append(name).append(": ");
                Object returnedObject = mmethod.invoke(object);

                // Value
                showValue(returnedObject, mmethod.getAnnotation(Json.class), sb);
                first = false;
            }
        }
        sb.append("\n}");
        return sb.toString();
    }

    private void showValue(Object object, Json annotation, StringBuffer sb) throws IllegalAccessException, InvocationTargetException {
         if (object == null) {
             sb.append("null");
             return;
         }
        Class<?> returnType = object.getClass();
        String value = "";

        if (Array.class.isAssignableFrom(returnType) || returnType.isArray()) {
            sb.append("[ ");
            boolean first = true;
            for (Object arrayObject : (Object[]) object) {
                if (!first) {
                    sb.append(", ");
                }
                showValue(arrayObject, annotation, sb);
                first = false;
            }
            sb.append(" ]");
        } else if (isNumber(returnType) || isBoolean(returnType)) {
            value = object.toString();
        } else if (Date.class.isAssignableFrom(returnType)) {
          String format = annotation.format();

          if (format.length() > 0) {
              Date date = (Date) object;
              SimpleDateFormat sdf = new SimpleDateFormat(format);
              value = "\"" + sdf.format(date) + "\"";
          } else {
              value = "\"" +object.toString() + "\"";
          }
        } else if(String.class.isAssignableFrom(returnType)) {
            value = "\"" + object.toString() + "\"";
        } else {
            value = generateJson(object);
        }

        sb.append(value);
    }

    private boolean isNumber(Class<?> mclass) {
        return Number.class.isAssignableFrom(mclass) ||
                Integer.TYPE.equals(mclass) ||
                Long.TYPE.equals(mclass) ||
                Float.TYPE.equals(mclass) ||
                Double.TYPE.equals(mclass);
    }

    private boolean isBoolean(Class<?> mclass) {
        return Boolean.class.isAssignableFrom(mclass) || Boolean.TYPE.equals(mclass);
    }
}
