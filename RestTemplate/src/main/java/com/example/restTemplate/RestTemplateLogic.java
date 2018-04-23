//package com.example.restTemplate;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//@Component
//public class RestTemplateLogic {
//	private static final Logger log = LoggerFactory.getLogger(RestTemplateApplication.class);
//	
//	public void restTemplateLogic() {
//		
//		System.out.println("hello");
//	
//	String url = "http://localhost:8080/topics";
//	RestTemplate restTemplate = new RestTemplate();		
//
//	HttpHeaders headers = new HttpHeaders();
//    headers.setContentType(MediaType.APPLICATION_JSON);
//    HttpEntity<Object> entity = new HttpEntity<Object>(headers);
//	
//    ResponseEntity<String> out = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//    System.out.println(out.getStatusCode());
//    System.out.println(out.getBody());
//    
//    Map<String, String> params = new HashMap<String, String>();
//    params.put("id", "0210");
//    params.put("name", "hellooooo");
//    params.put("description", "desc");
//    
//    ResponseEntity<String> response = restTemplate.postForEntity( url, params, String.class );
//	}
//
//}
