package com.seungho.springbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class SpringbootrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootrestApplication.class, args);
	}

	// 전역적으로 적용
	@Bean
	public WebClientCustomizer webClientCustomizer() {
		return new WebClientCustomizer() {
			@Override
			public void customize(WebClient.Builder webClientBuilder) {
				webClientBuilder.baseUrl("http://localhost:8080");
			}
		};
	}

	// RestTemplate 에서 Apache HttpClient 를 사용하도록 수정
	@Bean
	public RestTemplateCustomizer restTemplateCustomizer() {
		return new RestTemplateCustomizer() {
			@Override
			public void customize(RestTemplate restTemplate) {
				restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
			}
		};
	}
}
