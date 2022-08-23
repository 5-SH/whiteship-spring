package com.sh.springapp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {
//  @Value("${sh.name}")
//  private String name;
//
//  @Value("${sh.age}")
//  private int age;
//
//  @Value("${sh.fullName}")
//  private String fullName;

  @Autowired
  ShProperties shProperties;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("=======================");
    System.out.println(shProperties.getName());
    System.out.println(shProperties.getAge());
    System.out.println(shProperties.getFullName());
    System.out.println(shProperties.getSessionTimeout());
    System.out.println("=======================");
  }
}
