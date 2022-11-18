package com.example.springbootmongo;

import com.example.springbootmongo.account.Account;
import com.example.springbootmongo.account.AccountRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource(properties = "spring.mongodb.embedded.version=3.5.5")
@DataMongoTest
public class AccountRepositoryTest {
  @Autowired
  AccountRepository accountRepository;

  @Test
  public void findByEmail() {
    Account account = new Account();
    account.setUsername("seungho");
    account.setEmail("seungho@email.com");

    accountRepository.save(account);

    Optional<Account> byId = accountRepository.findById(account.getId());
    assertThat(byId).isNotEmpty();

    Optional<Account> byEmail = accountRepository.findByEmail(account.getEmail());
    assertThat(byEmail).isNotEmpty();
    assertThat(byEmail.get().getUsername()).isEqualTo("seungho");
  }
}
