package com.seungho.springtestdemo;

import com.seungho.springtestdemo.sample.SampleController;
import com.seungho.springtestdemo.sample.SampleService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@JsonTest
@WebMvcTest(SampleController.class)
//@AutoConfigureMockMvc
public class SampleControllerTest {

  @Autowired
  MockMvc mockMvc;

//  @Autowired
//  TestRestTemplate testRestTemplate;

  @MockBean
  SampleService mockSampleService;

//  @Autowired
//  WebTestClient webTestClient;

//  @Autowired
//  JacksonTester<SampleService> jsonTester;

  @Rule
  public OutputCapture outputCapture = new OutputCapture();

  @Test
  public void hello() throws Exception {
    when(mockSampleService.getName()).thenReturn("seungho");
    mockMvc.perform(get("/hello"))
            .andExpect(status().isOk())
            .andExpect(content().string("hello seungho"))
            .andDo(print());

//
//    String result = testRestTemplate.getForObject("/hello", String.class);
//    assertThat(result).isEqualTo("hello seungho");

//    webTestClient.get().uri("/hello").exchange().expectStatus().isOk()
//            .expectBody(String.class).isEqualTo("hello seungho");

    assertThat(outputCapture.toString())
            .contains("hello seungho 1")
            .contains("hello seungho 2");
  }
}
