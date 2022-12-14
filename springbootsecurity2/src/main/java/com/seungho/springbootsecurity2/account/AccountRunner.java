package com.seungho.springbootsecurity2.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {
  @Autowired
  AccountService accountService;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Account seungho = accountService.createAccount("seungho", "1234");
    System.out.println(seungho.getUsername() + " password: " + seungho.getPassword());
  }
}
