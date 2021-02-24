package main.com.zvuk.java.webapp.pages;
import main.com.zvuk.java.webapp.WebAttribute;
import main.com.zvuk.java.webapp.WebContent;
import main.com.zvuk.java.webapp.WebElement;
import main.com.zvuk.java.webapp.WebPage;
import main.com.zvuk.java.webapp.ParagrahElement;

import java.util.Dictionary;
import java.util.Hashtable;

public class HomePage extends WebPage {
    public HomePage(){
        super(new ParagrahElement(new WebContent("Hello world!"),new WebAttribute(new Hashtable<>())));
    }

    @Override
    public String toString() {
        return getElement().toString();
    }
}
