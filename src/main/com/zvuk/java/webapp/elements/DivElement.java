package main.com.zvuk.java.webapp.elements;

import main.com.zvuk.java.webapp.WebAttribute;
import main.com.zvuk.java.webapp.WebContent;
import main.com.zvuk.java.webapp.WebElement;

import java.util.ArrayList;

public class DivElement extends WebElement{
    ArrayList<WebElement> subElements;
    public DivElement(){
        super(new WebContent(""), new WebAttribute());
        subElements = new ArrayList<>();
    }

    public void addSubElement(WebElement element) {
        subElements.add(element);
    }

    @Override
    public String toString() {
        StringBuilder element = new StringBuilder("<div>");
        if (subElements.size() > 0) {
            for (WebElement subElement : subElements) {
                element.append(subElement.toString());
            }
        }
        element.append("</div>");
        return element.toString();
    }
}
