package com.seungho.springtestdemo.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  Logger logger = LoggerFactory.getLogger(SampleController.class);

  @Autowired
  private SampleService sampleService;

  @GetMapping("/hello")
  public String hello() {
    logger.info("hello " + sampleService.getName() + " 1");
    System.out.println("hello " + sampleService.getName() + " 2");
    return "hello " + sampleService.getName();
  }
}
