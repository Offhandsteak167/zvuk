package main.com.zvuk.java.webapp;

public class WebPage{

    private WebElement element;

    public WebPage(WebElement element){
        this.element = element;
    }

    public WebElement getElement() {
        return element;
    }
}

