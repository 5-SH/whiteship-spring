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
    /**
     * RestTemplate 는 Thread-Safe 하다.
     * 따라서 하나의 RestTemplate 를 여러 곳에서 동시에 사용해도 된다.
     * RestTempalte 는 http 요청을 보낼 때 디폴트로 SimpleClientHttpRequestFactory 를 활용해 처리한다.
     * SimpleClinetHttpRequestFactory 는 요청마다 Connectiom 을 만들고
     * 많은 기능이 빠져 있어 실제 프로젝트에서 사용하기에 무리가 있다.
     * Connection pool 같은 기능을 추가하고 싶으면 HttpComponentsClientHttpRequestFactory 를 사용해야 한다.
     *
     * RestTemplate 가 보통 커스터마이징 되어 사용되기 때문에
     * Springboot 에서는 자동 설정된  RestTemplate 를 제공하지 않는다.
     * 대신 자동 정된 Springboot 는 RestTemplateBuilder 를 제공해 필요할 때
     * HttpMessageConverters 등이 자동 설정된 RestTemplate 를 받을 수 있다.
     *
     * RestTemplate 를 커스터마이징 하는 방법은 3가지가 있는데,
     * 커스터마이징한 내용을 어떤 범위로 적용하려는지에 따라 선택할 수 있다.
     *
     * 1) 최대한 지역적으로 사용하고 싶으면 RestTemplateBuilder 를 메서드에 주입받고
     * 다시 커스터마이징한 후 필요에 따라 메서드를 호출한다. 각 메서드 호출은 새 RestTemplateBuilder
     * 인스턴스를 반환하므로 커스터마이징은 이 빌더를 사용할 때만 적용된다.
     *
     * 2) 애플리케이션 전체에 전역적으로 사용하고 싶으면 RestTemplateCustomizer 를 사용한다.
     * RestTemplateCustomizer 에 설정한 내용은 모든 RestTemplateBuilder 에 적용된다.
     *
     * 3) 커스터마이징 된 RestTemplateBuilder 빈을 새로 만든다.
     * RestTemplateCustomizer 에 커스터마이징한 내용을 새로 만든 RestTemplateBuilder 에
     * 적용하고 싶으면, RestTemplateBuilderConfigurer 를 활용해 커스터마이징 한다.
     */
//    RestTemplate restTemplate = restTemplateBuilder.build();
//    String helloResult = restTemplate.getForObject("http://localhost:8080/hello", String.class);
//    System.out.println(helloResult);
//    String worldResult = restTemplate.getForObject("http://localhost:8080/world", String.class);
//    System.out.println(worldResult);
//    stopwatch.stop();
//    System.out.println(stopwatch.prettyPrint());

    // Async non-blocking
    WebClient webClient = builder
            // 지역적으로 적용
//            .baseUrl("http://localhost:8080")
            .build();

    /**
     * webClient 첫 요청은 1s 정도 더 걸림
     * 정확한 테스트를 보내 hello, world 요청 전 init request 를 한 번 보내 webClient 를 준비시킴
     * init 요청 없이 바로 hello, world 요청을 보내면
     * world 응답에 4s 걸림
     */
    webClient.get()
//            .uri("http://localhost:8080/init")
            // 커스터마이징 설정 적용 후
            .uri("init")
            .retrieve()
            .bodyToMono(String.class)
            .subscribe(s -> {
              System.out.println(s);

              stopwatch.start();
            });

    webClient.get()
//            .uri("http://localhost:8080/hello")
            // 커스터마이징 설정 적용 후
            .uri("hello")
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

    webClient.get()
//            .uri("http://localhost:8080/world")
            // 커스터마이징 설정 적용 후
            .uri("world")
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
