package com.example.springbootredis;

import com.example.springbootredis.account.Account;
import com.example.springbootredis.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

  @Autowired
  StringRedisTemplate redisTemplate;

  @Autowired
  AccountRepository accountRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    try {
      ValueOperations<String, String> values = redisTemplate.opsForValue();
      values.set("seungho", "lemonhall");
      values.set("springboot", "2.7.5");
      values.set("hello", "world");

      Account account = new Account();
      account.setEmail("seungho@email.com");
      account.setUsername("seundgho");

      accountRepository.save(account);

      Optional<Account> byId = accountRepository.findById(account.getId());
      System.out.println(byId.get().getUsername());
      System.out.println(byId.get().getEmail());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
