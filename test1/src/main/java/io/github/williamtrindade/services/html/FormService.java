package io.github.williamtrindade.services.html;

import io.github.williamtrindade.annotations.Field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author William Trindade<williamtrindade777@gmail.com>
 */
public class FormService extends AbstractTags{
    private Method[] methods;
    private Object object;
    private StringBuilder content;

    // Constructor
    public FormService(Method[] methods, Object object, StringBuilder stringBuilder) {
        this.setMethods(methods);
        this.setObject(object);
        this.setContent(stringBuilder);
    }

    // Methods
    public Method[] getMethods() {
        return methods;
    }

    public void setMethods(Method[] methods) {
        this.methods = methods;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public StringBuilder getContent() {
        return content;
    }

    public void setContent(StringBuilder content) {
        this.content = content;
    }

    public void generateFields(Boolean readOnly) {
        for (Method objMethod : this.getMethods()) {
            if (this.isValidMethod(objMethod)) {

                Field annotation = objMethod.getAnnotation(Field.class);
                String annotationLabel = annotation.label();
                Field.FieldType fieldType = annotation.type();
                Integer size = annotation.size();
                String name = annotation.name();
                StringBuilder contentHtml = this.getContent();

                try {
                    Object invoked = objMethod.invoke(this.getObject());
                    if (invoked != null) {
                        if (invoked instanceof Boolean) {
                           this.generateBoolField(invoked, contentHtml, readOnly, name, annotationLabel);
                        } else {
                            if (fieldType == Field.FieldType.HIDDEN && !readOnly) {
                               // Is generated only if is not a read only field
                               this.generateHiddenField(invoked, contentHtml, name);
                            } else if (fieldType == Field.FieldType.TEXTAREA) {
                               this.generateTextAreaField(invoked, contentHtml, readOnly, name, annotationLabel);
                            } else if (fieldType == Field.FieldType.TEXT) {
                                this.generateTextField(invoked, contentHtml, readOnly, name, annotationLabel, size);
                            }
                        }
                    }
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void generateTextField(
            Object invoked,
            StringBuilder contentHtml,
            Boolean readOnly,
            String name,
            String annotationLabel,
            Integer size
    ) {
        contentHtml.append(openDiv())
                .append("\t\t<input type=\"text\" id=\"")
                .append(name)
                .append("\" name=\"")
                .append(name)
                .append("\" value=\"")
                .append(invoked)
                .append("\" size=\"")
                .append(size)
                .append(readOnly ? "\" readonly>\n" : "\"/>\n")
                .append("\t\t<label for=\"")
                .append(name)
                .append("\">")
                .append(annotationLabel)
                .append("</label>")
                .append(closeDiv());
    }

    private void generateTextAreaField(
            Object invoked,
            StringBuilder contentHtml,
            Boolean readOnly,
            String name,
            String annotationLabel
    ) {
        contentHtml.append(this.openDiv())
                .append("\t\t<textarea name=\"")
                .append(name)
                .append("\" id=\"")
                .append(name)
                .append(readOnly ? "\" readonly>" : "\">")
                .append(invoked)
                .append("</textarea>\n")
                .append("\t\t<label for=\"")
                .append(name)
                .append("\">")
                .append(annotationLabel)
                .append("</label>")
                .append(closeDiv());
    }

    private void generateHiddenField(Object invoked, StringBuilder contentHtml, String name) {
        contentHtml.append("\t<div>\n\t\t<input type=\"hidden\" name=\"")
                .append(name)
                .append("\" id=\"")
                .append(name)
                .append("\"")
                .append(" value=\"")
                .append(invoked)
                .append("\" />\n\t</div>\n");
    }

    private void generateBoolField(
            Object invoked,
            StringBuilder contentHtml, 
            Boolean readOnly, 
            String name, 
            String annotationLabel
    ) {
        final boolean invokedBoolean = (boolean) invoked;
        contentHtml.append(openDiv())
                .append("\t\t<input type=\"checkbox")
                .append("\" id=\"")
                .append(name)
                .append("\" name=\"")
                .append(name)
                .append("\" ");

        if (readOnly) {
            contentHtml.append("onclick=\"return false\" ");
        }
        if (invokedBoolean) {
            contentHtml.append("checked");
        }
        contentHtml.append("/>\n");
        contentHtml.append("\t\t<label for=\"")
                .append(name)
                .append("\">")
                .append(annotationLabel)
                .append("</label>")
                .append(closeDiv());
    }

    private boolean isValidMethod(Method method) {
        return method.getAnnotation(Field.class) != null
                && (method.getName().startsWith("get")
                || method.getName().startsWith("is"));
    }
}
