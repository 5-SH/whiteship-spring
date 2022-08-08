package org.example;

import me.sh.Holoman;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
/**
 * ==
 * @Configuration
 * @ComponentScan
 *   -> @Component, @Configuration, @Repository, @Service, @Controller, @RestController
 *      빈 등록
 * @EnableAutoConfiguration
 *   -> Maven:org.springframework.boot:spring-boot-autoconfigure:2.0.3.RELEASE
 *        META-INF/spring.factories
 *          org.springframework.boot.autoconfigure.EnableAutoConfiguration 키 값에 등록된
 *          @Configuration 빈들을 @ConditionalOn... 조건을 확인해 등록한다.
 *
 */
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
    }

    /**
     * @ComponentScan 에서 아래 빈을 등록하고
     * @EnableAutoConfiguration 에서 등록된 빈이 기존 빈을 덮어 씀
     * -> @EnableAutoConfiguration 에서 등록되는 빈에 @ConditionalOnMissingBean 추가
     */
//    @Bean
//    public Holoman holoman() {
//        Holoman holoman = new Holoman();
//        holoman.setName("seungho");
//        holoman.setHowLong(60);
//        return holoman;
//    }
}
