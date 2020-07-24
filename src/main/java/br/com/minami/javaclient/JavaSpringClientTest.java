package br.com.minami.javaclient;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.minami.Handler.RestExceptionHandler;
import br.com.minami.model.Laboratory;

public class JavaSpringClientTest {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplateBuilder()
				.rootUri("http://localhost:8080/exams/laboratory")
				.basicAuthentication("cristina.minami", "devdojo")
				.build();
		
		Laboratory laboratory = restTemplate.getForObject("/{id}", Laboratory.class, 1);
		ResponseEntity<Laboratory> forEntity = restTemplate.getForEntity("/{id}", Laboratory.class, 1);
		
		System.out.println(laboratory);
		System.out.println(forEntity.getBody());
		
		Laboratory[] laboratories = restTemplate.getForObject("/", Laboratory[].class);
		System.out.println("ARRAY " + Arrays.toString(laboratories));
		
		ResponseEntity<List<Laboratory>> exchange = restTemplate.exchange("/", HttpMethod.GET, null, new ParameterizedTypeReference<List<Laboratory>>() {});
		
		System.out.println("EXCHANGE " + exchange.getBody());
	}
}
