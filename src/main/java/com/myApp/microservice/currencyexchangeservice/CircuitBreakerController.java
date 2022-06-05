package com.myApp.microservice.currencyexchangeservice;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {

	
	@GetMapping("/sample-api")
	@Retry(name="sample-api",fallbackMethod="hardcoded")
	public String sampleAPI()
	{
	System.out.println("Sample API called");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/sample",String.class);
		return forEntity.getBody();
	}
	public String hardcoded(Exception ex)
	{
		return "fallback response";
	}
}
