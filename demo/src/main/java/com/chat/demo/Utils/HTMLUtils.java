package com.chat.demo.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class HTMLUtils {
    @Value("${parsingURL}")
    public static String parsingURL;

    public static Elements parseHTML(){
        Document doc= null;
        try {
            doc = Jsoup.connect(parsingURL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements= doc.getAllElements();
        return elements;
    }
}
