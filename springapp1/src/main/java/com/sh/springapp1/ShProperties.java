package com.sh.springapp1;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Component
@ConfigurationProperties("sh")
@Validated
public class ShProperties {
  @NotEmpty
  private String name;
  private int age;
  private String fullName;

  @DurationUnit(ChronoUnit.SECONDS)
  private Duration sessionTimeout;

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public String getFullName() {
    return fullName;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Duration getSessionTimeout() {
    return sessionTimeout;
  }

  public void setSessionTimeout(Duration sessionTimeout) {
    this.sessionTimeout = sessionTimeout;
  }
}
