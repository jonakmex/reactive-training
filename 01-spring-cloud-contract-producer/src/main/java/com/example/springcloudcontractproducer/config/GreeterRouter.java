package com.example.springcloudcontractproducer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@Configuration
public class GreeterRouter {

    @Bean
    RouterFunction<ServerResponse> routes(){
        return RouterFunctions.route()
                .GET("/hello",request -> ServerResponse.ok().contentType(APPLICATION_JSON).body(Mono.just("hello"),String.class))
                .build();
    }
}
