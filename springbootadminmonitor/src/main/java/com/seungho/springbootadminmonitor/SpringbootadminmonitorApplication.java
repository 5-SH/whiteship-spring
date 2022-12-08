package com.seungho.springbootadminmonitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class SpringbootadminmonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootadminmonitorApplication.class, args);
	}

}
