package com.sh.springapp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner2 implements ApplicationRunner {
  @Autowired
  private String hello;

  @Autowired
  private ShProperties shProperties;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("=======================");
    System.out.println(hello);
    System.out.println(shProperties.getName());
    System.out.println(shProperties.getFullName());
    System.out.println("=======================");
  }
}
