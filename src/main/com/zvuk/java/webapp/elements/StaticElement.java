package main.com.zvuk.java.webapp.elements;

import main.com.zvuk.java.webapp.WebAttribute;
import main.com.zvuk.java.webapp.WebContent;
import main.com.zvuk.java.webapp.WebElement;

import java.util.Hashtable;

public class StaticElement extends WebElement {
    public StaticElement(WebContent content){
        super(content, new WebAttribute(new Hashtable<>()));
    }

    @Override
    public String toString() {
        return getContent().getValue();
    }
}
