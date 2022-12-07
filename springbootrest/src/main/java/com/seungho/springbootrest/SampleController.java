package com.seungho.springbootrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

  @GetMapping("/init")
  public String init() {
    return "init";
  }

  @GetMapping("/hello")
  public String hello() throws InterruptedException {
    Thread.sleep(5000l);
    return "hello";
  }

  @GetMapping("/world")
  public String world() throws InterruptedException {
    Thread.sleep(3000l);
    return "world";
  }
}
