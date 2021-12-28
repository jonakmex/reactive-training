package com.example.springcloudcontractclient.client;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class GreeterClient {

    private final WebClient webClient;

    public Mono<String> greet() {
        return this.webClient
                .get()
                .uri("http://localhost:8080/hello")
                .retrieve().bodyToMono(String.class);
    }
}
