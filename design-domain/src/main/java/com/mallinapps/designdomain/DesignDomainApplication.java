package com.mallinapps.designdomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mallinapps")
public class DesignDomainApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignDomainApplication.class, args);
	}

}
