package com.example.springbootsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 로직이 없고 단순히 요청을 받아 view 이름만 전달하는 컨트롤러는 컨트롤러를 구현하는 대신
 * 아래와 같이 addViewController 로 간단히 만들 수 있다.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    WebMvcConfigurer.super.addViewControllers(registry);

//    registry.addViewController("/hello").setViewName("hello");
  }
}
