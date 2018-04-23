package com.example.restTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;



@SpringBootApplication
@EnableScheduling
public class RestTemplateApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RestTemplateApplication.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	
	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
//		RestTemplateLogic run = new RestTemplateLogic();
//		run.restTemplateLogic();
	}
	
	
//	@Scheduled(fixedRate = 3000)
	@Scheduled(cron = "0/14 * * * * *")
	public void restTempalteLogic() {
		
		String url = "http://localhost:8080/topics";
		RestTemplate restTemplate = new RestTemplate();		

//		GET Request
//		HttpHeaders headers = new HttpHeaders();
//	    headers.setContentType(MediaType.APPLICATION_JSON);
//	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);
//	    ResponseEntity<String> out = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//	    System.out.println(out.getStatusCode());
//	    System.out.println(out.getBody());
		
		try {
		ResponseEntity<String> out = restTemplate.getForEntity(url, String.class);
		System.out.println("The time is now:" +dateFormat.format(new Date()));
	    System.out.println(out.getStatusCode());
	    System.out.println(out.getBody());
		} catch (HttpStatusCodeException e) {
			String errorpayload = e.getResponseBodyAsString();
//			System.out.println(errorpayload);
			log.error(errorpayload);
		}
		
//	GET Request End
		
//	    POST Request
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "8520");
	    params.put("name", "testing");
	    params.put("description", "test_desc");
	    
	    try {
	    ResponseEntity<String> response = restTemplate.postForEntity( url, params, String.class );
	    System.out.println(response.getStatusCode());
	    } catch (HttpStatusCodeException e) {
			String errorpayload = e.getResponseBodyAsString();
			System.out.println(errorpayload);
		log.error(errorpayload);
		}
//		POST Request End
	}
}