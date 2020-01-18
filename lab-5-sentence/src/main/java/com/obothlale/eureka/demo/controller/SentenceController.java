package com.obothlale.eureka.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class SentenceController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/sentence")
    public String getSentence() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] servers = {"SUBJECT", "VERB", "ARTICLE", "ADJECTIVE", "NOUN"};
        for (String serverName : servers) {
            stringBuilder.append(getWordsFrom(serverName) + " ");
        }
        return stringBuilder.toString();
    }

    private String getWordsFrom(String serverName) {
        return restTemplate.getForObject("http://" + serverName, String.class);
    }
}
