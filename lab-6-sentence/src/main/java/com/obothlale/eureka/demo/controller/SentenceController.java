package com.obothlale.eureka.demo.controller;

import com.obothlale.eureka.demo.model.Word;
import com.obothlale.eureka.demo.service.SentenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentenceController {

    @Autowired
    private SentenceService sentenceService;



    @GetMapping("/sentence")
    public String getSentence() {
        return sentenceService.getSentence();
    }

    /*TODO still need to get Feign builder to work*/
//    @Autowired
//    private Word subject;
    /*public String getSentence() {
        return subject.getWord();
    }*/

}
