package com.fiba.spring.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;


@Controller
public class TransferController {

	@GetMapping("/client/header") 
	@ResponseBody
	public String getHeader() {
		String url = "http://localhost:8080/transfer/header";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("input","godoro");
		HttpEntity<String> entity = new HttpEntity<>("Gövde" ,headers);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET, entity, String.class);
		return "Başlık gönderildi> " +response.getBody();
	}

	@GetMapping("/client/setheader") 
	@ResponseBody
	public String setHeader() {
		String url = "http://localhost:8080/transfer/setheader";
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.add("input","godoro");
		HttpEntity<String> entity = new HttpEntity<>("Gövde" ,headers);
		ResponseEntity<String> response=restTemplate.exchange(url,HttpMethod.GET, entity, String.class);
		String input = response.getHeaders().getFirst("input"); 
		return "Başlık alındı> " +response.getBody() +"başlık: "+input;
	}	
}
