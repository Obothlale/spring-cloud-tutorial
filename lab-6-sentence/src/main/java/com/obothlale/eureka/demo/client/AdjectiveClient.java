package com.obothlale.eureka.demo.client;

import com.obothlale.eureka.demo.model.Word;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("ADJECTIVE")
public interface AdjectiveClient {
    @GetMapping("/")
    Word getWord();
}
