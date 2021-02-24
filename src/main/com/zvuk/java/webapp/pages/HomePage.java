package main.com.zvuk.java.webapp.pages;
import main.com.zvuk.java.server.Database;
import main.com.zvuk.java.webapp.WebAttribute;
import main.com.zvuk.java.webapp.WebContent;
import main.com.zvuk.java.webapp.WebPage;
import main.com.zvuk.java.webapp.elements.BoldElement;
import main.com.zvuk.java.webapp.elements.DivElement;
import main.com.zvuk.java.webapp.elements.ParagrahElement;

import java.util.Hashtable;

public class HomePage extends WebPage {
    public HomePage(){
        addElement((new ParagrahElement(new WebContent("Hello world!"))));
        addElement((new BoldElement(new WebContent("Cool elements!"),new WebAttribute(new Hashtable<>()))));
        addElement((new DivElement()));
        ((DivElement) getElement(2)).addSubElement((new ParagrahElement(new WebContent("This is structured!"))));
        ((DivElement) getElement(2)).addSubElement((new ParagrahElement(new WebContent("This is structured too!"))));
        addElement((new ParagrahElement(new WebContent("Company Name: "+ Database.companies.get(2).getName()))));

    }

    @Override
    public String toString() {
        StringBuilder body = new StringBuilder("<body>");
        for (int i = 0; i < getElements().size(); i++) {
            body.append(getElement(i));
        }
        body.append("</body>");
        return body.toString();
    }
}
