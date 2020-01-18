package com.obothlale.eureka.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController {

    @Value("${words}")
    private String words;

    @GetMapping("/")
    public String getWords() {
        String[] wordList = words.split(",");
        int i = (int) Math.round(Math.random() * (wordList.length - 1));
        return wordList[i];
    }
}
