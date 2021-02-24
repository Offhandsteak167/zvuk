package main.com.zvuk.java.webapp.pages;
import main.com.zvuk.java.server.dummy.DummyDatabase;
import main.com.zvuk.java.webapp.WebAttribute;
import main.com.zvuk.java.webapp.WebContent;
import main.com.zvuk.java.webapp.WebPage;
import main.com.zvuk.java.webapp.elements.BoldElement;
import main.com.zvuk.java.webapp.elements.DivElement;
import main.com.zvuk.java.webapp.elements.ParagrahElement;
import main.com.zvuk.java.webapp.elements.StaticElement;
import main.com.zvuk.java.webapp.parser.HTMLParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class HomePage extends WebPage {
    public HomePage(){
        addElement((new ParagrahElement(new WebContent("Hello world!"))));
        addElement((new BoldElement(new WebContent("Cool elements!"),new WebAttribute(new Hashtable<>()))));
        addElement((new DivElement()));
        System.out.println(getElement(2).toString());
        ((DivElement) getElement(2)).addSubElement((new ParagrahElement(new WebContent("This is structured!"))));
        ((DivElement) getElement(2)).addSubElement((new ParagrahElement(new WebContent("This is structured too!"))));
        addElement((new ParagrahElement(new WebContent(DummyDatabase.companies.get(2).getName()))));
        addElement((new ParagrahElement(new WebContent(DummyDatabase.companies.get(0).getMeetingQueue().toString()))));




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
