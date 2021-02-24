package main.com.zvuk.java.webapp.elements;

import main.com.zvuk.java.webapp.WebAttribute;
import main.com.zvuk.java.webapp.WebContent;
import main.com.zvuk.java.webapp.WebElement;

public class BoldElement extends WebElement {
    public BoldElement(WebContent content, WebAttribute attribute){
        super(content, attribute);
    }

    @Override
    public String toString() {
        return "<b>"+getContent().getValue()+"</b>";
    }
}
