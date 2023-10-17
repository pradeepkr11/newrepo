package com.myproject.javareceipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JavareceiptApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavareceiptApplication.class, args);
	}

}
