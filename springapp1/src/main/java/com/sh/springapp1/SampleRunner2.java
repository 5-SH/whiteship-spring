package com.sh.springapp1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner2 implements ApplicationRunner {

  private Logger logger = LoggerFactory.getLogger(SampleRunner2.class);

  @Autowired
  private String hello;

  @Autowired
  private ShProperties shProperties;

  @Override
  public void run(ApplicationArguments args) throws Exception {
//    System.out.println("=======================");
//    System.out.println(hello);
//    System.out.println(shProperties.getName());
//    System.out.println(shProperties.getFullName());
//    System.out.println("=======================");

    logger.debug("=======================");
    logger.debug(hello);
    logger.debug(shProperties.getName());
    logger.debug(shProperties.getFullName());
    logger.debug("=======================");
  }
}
