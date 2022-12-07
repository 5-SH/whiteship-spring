package com.seungho.springbootrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class RestRunner implements ApplicationRunner {

  @Autowired
  RestTemplateBuilder restTemplateBuilder;

  @Autowired
  WebClient.Builder builder;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    StopWatch stopwatch = new StopWatch();

    // Sync blocking
//    stopwatch.start();
//    RestTemplate restTemplate = restTemplateBuilder.build();
//    String helloResult = restTemplate.getForObject("http://localhost:8080/hello", String.class);
//    System.out.println(helloResult);
//    String worldResult = restTemplate.getForObject("http://localhost:8080/world", String.class);
//    System.out.println(worldResult);
//    stopwatch.stop();
//    System.out.println(stopwatch.prettyPrint());

    // Async non-blocking
    WebClient webClient = builder.build();

    /**
     * webClient 첫 요청은 1s 정도 더 걸림
     * 정확한 테스트를 보내 hello, world 요청 전 init request 를 한 번 보내 webClient 를 준비시킴
     * init 요청 없이 바로 hello, world 요청을 보내면
     * world 응답에 4s 걸림
     */
    webClient.get().uri("http://localhost:8080/init")
            .retrieve()
            .bodyToMono(String.class)
            .subscribe(s -> {
              System.out.println(s);

              stopwatch.start();
            });

    webClient.get().uri("http://localhost:8080/hello")
            .retrieve()
            .bodyToMono(String.class)
            .subscribe(s -> {
              System.out.println(s);

              if (stopwatch.isRunning()) {
                stopwatch.stop();
              }

              System.out.println(stopwatch.prettyPrint());
              stopwatch.start();
            });

    webClient.get().uri("http://localhost:8080/world")
            .retrieve()
            .bodyToMono(String.class)
            .subscribe(s -> {
              System.out.println(s);

              if (stopwatch.isRunning()) {
                stopwatch.stop();
              }

              System.out.println(stopwatch.prettyPrint());
              stopwatch.start();
            });

  }
}
