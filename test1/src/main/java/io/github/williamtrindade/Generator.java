package io.github.williamtrindade;

import io.github.williamtrindade.services.html.ContentService;
import io.github.williamtrindade.services.html.FormService;

import java.util.Map;

public enum Generator implements FormGenerator {
    GENERATOR;

    @Override
    public String generateForm(Object object) {
        ContentService contentService = new ContentService(object);
        return contentService.generateHTML(false);
    }

    @Override
    public String generateReadOnlyView(Object object) {
        return null;
    }

    @Override
    public Object populateObject(Map<String, String> requestParams, Class classe) {
        return null;
    }
}
