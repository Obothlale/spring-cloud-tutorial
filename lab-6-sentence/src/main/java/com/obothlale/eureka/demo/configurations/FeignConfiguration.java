package com.obothlale.eureka.demo.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.obothlale.eureka.demo.model.Word;
import feign.Client;
import feign.Feign;
import feign.form.FormEncoder;
//import feign.jackson.JacksonDecoder;
//import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FeignConfiguration {

    //TODO still need to get this to work
//    @Bean
    public Word subject(Client feignClient, ObjectMapper objectMapper) {
        return Feign.builder()
                .client(feignClient)
//                .encoder(new FormEncoder(new JacksonEncoder(objectMapper)))
//                .decoder(new JacksonDecoder(objectMapper))
                .target(Word.class, "http://SUBJECT");
    }
}
