package io.github.williamtrindade;

import java.util.Map;

public enum Generator implements FormGenerator {
    GENERATOR;
    @Override
    public String generateForm(Object object) {
        return null;
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
