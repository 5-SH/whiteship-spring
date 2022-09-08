package com.sh.springapp1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
//@TestPropertySource(locations = {"classpath:/application.properties"})
@TestPropertySource(locations = {"classpath:/test.properties"})
@SpringBootTest
class Springapp1ApplicationTests {

	@Autowired
	Environment environment;

	@Test
	void contextLoads() {
//		Assertions.assertThat(environment.getProperty("sh.name"))
//						.isEqualTo("seungho");

		Assertions.assertThat(environment.getProperty("sh.name"))
						.isEqualTo("seungho2");
	}
}
