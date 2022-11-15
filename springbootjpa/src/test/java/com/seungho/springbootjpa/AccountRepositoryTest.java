package com.seungho.springbootjpa;

import com.seungho.springbootjpa.account.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)

/**
 * for slicing test
 * DataJpaTest default 로 내장 db 사용 -> h2
 */
//@DataJpaTest
/**
 * for integration test
 * @SpringBootApplication 을 찾아서 모든 빈 설정 등록함
 * SpringbootjpaApplication 의 모든 빈 등록 -> application.properties 적용됨 -> postgresql
 */
@SpringBootTest
public class AccountRepositoryTest {
  @Autowired
  DataSource dataSource;

  @Autowired
  JdbcTemplate jdbcTemplate;

  @Autowired
  AccountRepository accountRepository;

  @Test
  public void di() throws SQLException {
    try (Connection connection = dataSource.getConnection()) {
      DatabaseMetaData metaData = connection.getMetaData();

      System.out.println(metaData.getURL());
      System.out.println(metaData.getDriverName());
      System.out.println(metaData.getUserName());
    }

    Account account= new Account();
    account.setUsername("seungho");
    account.setPassword("pass");

    Account newAccount = accountRepository.save(account);

    assertThat(newAccount).isNotNull();

    Optional<Account> existingAccount = accountRepository.findByUsername(newAccount.getUsername());
    assertThat(existingAccount).isNotEmpty();

    Optional<Account> nonExistingAccount = accountRepository.findByUsername("noname");
    assertThat(nonExistingAccount).isEmpty();
  }
}
