package com.example.demo.config;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("timer:miTimer?period=30000") // cada 30 segundos
                .log("Hola Camel !");
    }
}
