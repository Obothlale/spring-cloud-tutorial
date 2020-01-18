package com.obothlale.ribbon.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordServerController {

    @Value("${words}")
    private String words;

    @GetMapping("/")
    public String getWords() {
        String[] wordList = words.split(",");
        int index = (int) Math.round(Math.random() * (wordList.length - 1));
        return wordList[index];
    }
}
