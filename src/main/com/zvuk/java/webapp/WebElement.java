package main.com.zvuk.java.webapp;

public abstract class WebElement {
    WebContent content;
    WebAttribute attribute;
    int id;
    public WebElement(WebContent content, WebAttribute attribute){
        this.content = content;
        this.attribute = attribute;
        this.id = 0;
    }

    public WebContent getContent() {
        return content;
    }
}
