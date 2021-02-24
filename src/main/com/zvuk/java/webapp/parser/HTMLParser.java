package main.com.zvuk.java.webapp.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HTMLParser {
    public static ArrayList<String> parse() throws IOException {
        File input = new File("test.html");
        Document doc = Jsoup.parse(input, "UTF-8", "");
        ArrayList<String> toReturn = new ArrayList<>();
        //log(doc.title());
        Elements elements = doc.getElementsByTag("p");
        for (Element element : elements) {
            toReturn.add(element.text());
            System.out.println(element.text());
        }
        return toReturn;
    }
}
