package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebAppConfig {

    @Bean
    public WebClient webClient() {
        return WebClient.create(); // se puede pasar una base URL si querés
    }
}
