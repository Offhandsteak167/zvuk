package main.com.zvuk.java.webapp;

import java.util.Dictionary;
import java.util.Hashtable;

public class WebAttribute {
    private Dictionary<String, String> attributeDictionary;

    public WebAttribute(Hashtable<String, String> attributeDictionary) {
        this.attributeDictionary = attributeDictionary;
    }

    public WebAttribute() {
        this.attributeDictionary = new Hashtable<>();
    }
}
