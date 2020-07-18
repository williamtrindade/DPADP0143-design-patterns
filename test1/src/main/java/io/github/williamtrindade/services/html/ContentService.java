package io.github.williamtrindade.services.html;

import io.github.williamtrindade.annotations.Form;

/**
 * @author William Trindade<williamtrindade777@gmail.com>
 */
public class ContentService extends AbstractTags {
    private Object object;

    // Constructor
    public ContentService(Object object) {
        this.setObject(object);
    }

    // Methods
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String generateHTML(Boolean readOnly) {
        Class<?> objectClass = this.object.getClass();
        Form annotationClass = objectClass.getAnnotation(Form.class);

        StringBuilder content = new StringBuilder();

        content.append(this.openForm())
                .append(annotationClass.name())
                .append(this.openAction())
                .append(annotationClass.action())
                .append(this.closeAction());

        FormService formService = new FormService(objectClass.getDeclaredMethods(), this.object, content);
        formService.generateFields(readOnly);
        content = formService.getContent();

        content.append(openDiv())
                .append("\t\t<input type=\"submit\" value=\"")
                .append(annotationClass.submitButton())
                .append(this.closeTag())
                .append(closeDiv())
                .append(this.closeForm());

        return content.toString();
    }


}
