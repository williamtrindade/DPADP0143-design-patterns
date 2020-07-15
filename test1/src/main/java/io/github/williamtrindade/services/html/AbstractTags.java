package io.github.williamtrindade.services.html;

public class AbstractTags {
    protected String openDiv() {
        return "\t<div>\n";
    }

    protected String closeDiv() {
        return "\n \t</div>\n";
    }

    protected String openForm() {
        return "<form name=\"";
    }

    protected String openAction() {
        return "\" action=\"";
    }

    protected String closeForm() {
        return "</form>";
    }

    protected String closeAction() {
        return "\">\n";
    }

    protected String closeTag() {
        return "\" />";
    }
}
