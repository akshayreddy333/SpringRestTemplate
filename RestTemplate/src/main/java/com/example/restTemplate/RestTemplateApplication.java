package com.example.restTemplate;

import java.util.ArrayList;
import java.util.Arrays;
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
import org.springframework.web.client.RestTemplate;

import net.minidev.json.JSONObject;


@SpringBootApplication
@EnableScheduling
public class RestTemplateApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestTemplateApplication.class, args);
		
		String url = "http://localhost:8080/topics";
		RestTemplate restTemplate = new RestTemplate();		

		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<Object> entity = new HttpEntity<Object>(headers);
		
	    ResponseEntity<String> out = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	    System.out.println(out.getStatusCode());
	    System.out.println(out.getBody());
	    
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "0210");
	    params.put("name", "hellooooo");
	    params.put("description", "desc");
	    
	    ResponseEntity<String> response = restTemplate.postForEntity( url, params, String.class );
	}
}
