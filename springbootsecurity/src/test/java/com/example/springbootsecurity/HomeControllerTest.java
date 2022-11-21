package com.example.springbootsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {
  @Autowired
  MockMvc mockMvc;

  @Test
  @WithMockUser
  public void hello() throws Exception {
    /**
     * 요청을 보낼 때 accept header 값을 TEXT_HTML 로 설정해 보내면,
     * 스프링 시큐리티가 제공하는 기본적인 로그인 폼으로 리다이렉트 하는 301 응답을 스프링 시큐리티가 디폴트로 보냄.
     *
     * accept header 값을 설정하지 않으면,
     * 401 에러 코드와 함께 브라우저에 내장된 기본 에러 페이지로 보내는
     * WWW-Authenticate:"Basic realm="Realm"" header 를 응답에 담아 보냄
     *
     * spring security 설정은 SecurityAutoConfiguration 클래스에서 설정한다.
     * SecurityAutoConfiguration 에서 security 관련된 이벤트를 핸들링하는 디폴트 핸들러를 등록하고
     * SpringBootWebSecurityConfiguration 으로 기본 설정을 한다.
     *
     * SecurityFilterChainConfiguration 의 defaultSecurityFilterChain 에서 HttpSecurity 를 통해
     * 주요 설정을 하는데 http.authorizeRequests().anyRequest().authenticated(); 에서
     * 모든 요청에 대해 인증을 요구하도록 설정한다.
     *
     * 스프링부트 자동 설정에서 spring security 관련해 자동 설정하는 것은
     * UserDetailsServiceAutoConfiguration 를 통해 기본 계정을 생성하는 것 외에는 특별히 하는 것이 없다.
     */
    mockMvc.perform(get("/hello")
                    .accept(MediaType.TEXT_HTML))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("hello"));
  }

  @Test
  public void hello_without_user() throws Exception {
    mockMvc.perform(get("/hello"))
            .andDo(print())
            .andExpect(status().isUnauthorized());
  }

  @Test
  @WithMockUser
  public void my() throws Exception {
    mockMvc.perform(get("/my"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("my"));
  }
}
