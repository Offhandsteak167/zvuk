package main.com.zvuk.java.webapp;

import java.util.ArrayList;

public class WebPage{

     ArrayList<WebElement> elements;

    public WebPage(){
        this.elements = new ArrayList<>();
    }

    public WebElement getElement(int index) {
        return elements.get(index);
    }

    public void addElement(WebElement element) {
        elements.add(element);
    }

    public ArrayList<WebElement> getElements() {
        return elements;
    }

}

