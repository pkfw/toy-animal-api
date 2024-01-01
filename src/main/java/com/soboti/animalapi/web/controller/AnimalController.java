package com.soboti.animalapi.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AnimalController {

    @GetMapping("/api/animal")
    public Map<String, Object> getAnimal(String en) {
        Map<String, Object> resultMap = new HashMap<>();
        if (en.equals("pig")) {
            resultMap.put("animal", "돼지");
            resultMap.put("dataType", "db");
        } else if (en.equals("horse")) {
            resultMap.put("animal", "말");
            resultMap.put("dataType", "db");
        } else if (en.equals("dog")) {
            resultMap.put("animal", "개");
            resultMap.put("dataType", "db");
        } else if (en.equals("cat")) {
            resultMap.put("animal", "고양이");
            resultMap.put("dataType", "db");
        } else if (en.isEmpty() || en.isBlank()) {
            resultMap.put("animal", "animal is blank");
            resultMap.put("dataType", "");
        } else {
            resultMap.put("animal", "null");
            resultMap.put("dataType", "");
        }
        return resultMap;
    }
}
