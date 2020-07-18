package io.github.williamtrindade.services.html;

/**
 * @author William Trindade<williamtrindade777@gmail.com>
 */
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
