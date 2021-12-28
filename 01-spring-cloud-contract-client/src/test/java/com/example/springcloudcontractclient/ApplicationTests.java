package com.example.springcloudcontractclient;

import com.example.springcloudcontractclient.client.GreeterClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.function.Predicate;

@SpringBootTest
@AutoConfigureStubRunner(ids = "com.example:01-spring-cloud-contract-producer:+:8080",stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class ApplicationTests {

	@Autowired
	private GreeterClient greeterClient;

	@Test
	void contextLoads() {
		Mono<String> greet = this.greeterClient.greet();
		StepVerifier.create(greet)
				.expectNextMatches(s -> "hello".equals(s))
				.verifyComplete();
	}

}
