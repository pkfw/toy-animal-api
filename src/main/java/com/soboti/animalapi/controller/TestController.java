package com.soboti.animalapi.controller;

import com.soboti.animalapi.service.JsoupService;
import com.soboti.animalapi.service.UrlService;
import org.jsoup.Connection;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.NoSuchElementException;

@RestController
public class TestController {
    @GetMapping("/api/test/jsoup")
    public HashMap<String, String> getTestJsoup(String translate) {
        // result type is HashMap<String, String> :: json
        HashMap<String, String> result = new HashMap<>();
        result.put("request", translate);

        // parameter null check
        if (translate == null) {
            result.put("response", "translate is null");
            return result;
        }
        String url = new UrlService().getTranslateUrl("google", translate);

        // jsoup parse
        JsoupService jsoupService = new JsoupService();
        Connection connection = jsoupService.getConnection(url);
        Elements elements = null;

        // ask google translate
        String selector = "[data-entityname=\"Google Translate\"] [lang=\"ko\"]";

        // ask naver papago
//        String selector = "#txtTarget";

        String searchResult = null;
        try {
            elements = jsoupService.getJsoupElements(connection, selector);
            searchResult = elements.eachText().getFirst();
        } catch (NoSuchElementException e) {
            searchResult = "no such element";
        } catch (Exception e) {
            searchResult = e.toString();
        }

        result.put("response", searchResult);
        return result;
    }
}
