package com.sh.springapp1;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SampleListener implements CommandLineRunner {

  @Override
  public void run(String... args) throws Exception {
    Arrays.stream(args).forEach(System.out::println);
  }
}
