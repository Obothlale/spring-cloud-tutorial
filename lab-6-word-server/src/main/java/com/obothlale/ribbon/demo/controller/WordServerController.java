package com.obothlale.ribbon.demo.controller;

import com.obothlale.ribbon.demo.model.Word;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WordServerController {

    private final Random random = new Random();

    @Value("${words}")
    private String[] words;

    @GetMapping("/")
    public Word getWords() {
        return new Word(words[random.nextInt(words.length)]);
    }
}
