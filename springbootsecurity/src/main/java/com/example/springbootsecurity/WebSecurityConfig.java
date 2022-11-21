package com.example.springbootsecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SpringBootWebSecurityConfiguration 의 @ConditionalOnDefaultWebSecurity 에서
 * DefaultWebSecurityCondition 조건일 때 spring security 설정을 하도록 되어있다.
 * DefaultWebSecurityCondition 은 WebSecurityConfigurerAdapter 나 SecurityFilterChain 가 빈으로 없을때
 * 동작하도록 되어있다.
 *
 * 따라서 아래와 같이 WebSecurityConfigurerAdapter 를 상속받아 설정 빈을 만들면
 * SecurityFilterChainConfiguration 이 동작하지 않아 자동 설정되지 않고
 * 아래 WebSecurityConfig 설정을 따르게 된다.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
}
