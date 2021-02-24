package main.com.zvuk.java.webapp;

public interface Servable {
    String toString();
    String getElement(WebElement element);
    void setElement(WebElement element, String content);
}
