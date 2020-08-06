package com.chat.demo.Utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class HTMLUtils {

    public static Elements parseHTML(String url){
        Document doc= null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements= doc.getAllElements();
        return elements;
    }
}
