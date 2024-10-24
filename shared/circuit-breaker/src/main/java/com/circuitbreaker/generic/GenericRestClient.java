package com.circuitbreaker.generic;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@Component
public class GenericRestClient {

    public static final String USER_SERVICE="userService";

	 int attemptMethod=1,attemptCircuit=1,attempt=1;
	public <K, T> K post(String url, T request, Class<K> clazz) {

		RestTemplate restTemplate=new RestTemplate();
		K response =  restTemplate.postForObject(url,request, clazz);
		
		return response;

	}
	
    @CircuitBreaker(name = USER_SERVICE,fallbackMethod = "getVerifyMerchantInfo")
	public <K, T> K postCircuitBreaker(String url, T request, Class<K> clazz) {
        System.out.println("postCircuitBreaker "+attemptCircuit++ +" times "+" at "+new Date());

		RestTemplate restTemplate=new RestTemplate();
		K response =  restTemplate.postForObject(url,request, clazz);
		
		return response;

	}
	
    @Retry(name = USER_SERVICE,fallbackMethod = "getVerifyMerchantInfo")
	public <K, T> K postRetry(String url, T request, Class<K> clazz) {
        System.out.println("postRetry "+attempt++ +" times "+" at "+new Date());

		RestTemplate restTemplate=new RestTemplate();
		K response =  restTemplate.postForObject(url,request, clazz);
		
		return response;

	}
    public <K, T> K getVerifyMerchantInfo(Exception e){
        System.out.println("getAllAvailableProducts "+attemptMethod++ +" times "+" at "+new Date());
		K response =  (K) "Please work";

        return response; 
    }
}
