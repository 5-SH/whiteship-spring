package com.example.springbootneo4j.account;

import com.example.springbootneo4j.account.Account;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AccountRepository extends Neo4jRepository<Account, Long> {
}
