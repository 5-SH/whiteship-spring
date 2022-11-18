package com.example.springbootneo4j;

import com.example.springbootneo4j.account.Account;
import com.example.springbootneo4j.account.AccountRepository;
import com.example.springbootneo4j.account.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {

  @Autowired
  AccountRepository accountRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    Account account = new Account();
    account.setEmail("lemonhall@email.com");
    account.setUsername("lemonhall");

    Role role = new Role();
    role.setName("admin");
    account.getRoles().add(role);

    accountRepository.save(account);
  }
}
