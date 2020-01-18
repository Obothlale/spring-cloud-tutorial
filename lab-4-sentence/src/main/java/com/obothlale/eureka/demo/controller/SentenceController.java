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
    private DiscoveryClient discoveryClient;

    @GetMapping("/sentence")
    public String getSentence() {
        StringBuilder stringBuilder = new StringBuilder();
        String[] servers = {"LAB-4-SUBJECT", "LAB-4-VERB", "LAB-4-ARTICLE", "LAB-4-ADJECTIVE", "LAB-4-NOUN"};
        for (String serverName : servers) {
            stringBuilder.append(getWordsFrom(serverName) + " ");
        }
        return stringBuilder.toString();
    }

    private String getWordsFrom(String serverName) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serverName);
        if (serviceInstances != null && serviceInstances.size() > 0) {
            URI uri = serviceInstances.get(0).getUri();
            if (uri != null) {
                return (new RestTemplate()).getForObject(uri, String.class);
            }
        }
        return null;
    }
}
