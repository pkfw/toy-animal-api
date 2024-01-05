package com.soboti.animalapi.service;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class JsoupService {
    /**
     * @param url
     * @return
     */
    public static Connection getConnection(String url) {
        return Jsoup.connect(url);
    }

    /**
     * @param connection
     * @param selector
     * @return
     */
    public static Elements getJsoupElements(Connection connection, String selector) {
        Elements elements = null;
        try {
            elements = connection.get().select(selector);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elements;
    }
}
