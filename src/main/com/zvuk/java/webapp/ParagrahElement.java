package main.com.zvuk.java.webapp;

public class ParagrahElement extends WebElement{
    public ParagrahElement(WebContent content, WebAttribute attribute){
        super(content, attribute);
    }

    @Override
    public String toString() {
        return "<p>"+getContent().getValue()+"</p>";
    }
}
