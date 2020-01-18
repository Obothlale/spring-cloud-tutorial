package com.obothlale.spring.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckyWordController {
    @Value("${lucky-word}")
    private String luckyWord;

    @GetMapping("/lucky-word")
    public String getLuckyWord() {
        return "The lucky word is: " + luckyWord;
    }
}
