package com.sh.springapp1;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.swing.*;

@SpringBootApplication
public class Springapp1Application {

	public static void main(String[] args) {
//		SpringApplication.run(Springapp1Application.class, args);

		SpringApplication app = new SpringApplication(Springapp1Application.class);
		app.setBannerMode(Banner.Mode.OFF);
//		app.addListeners(new SampleListener());
		app.run(args);

//		new SpringApplicationBuilder()
//						.sources(Springapp1Application.class)
//						.listeners(new SampleListener())
//						.run(args);


	}

}
