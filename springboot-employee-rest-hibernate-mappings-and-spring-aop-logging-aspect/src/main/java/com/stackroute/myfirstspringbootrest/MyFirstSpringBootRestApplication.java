package com.stackroute.myfirstspringbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class MyFirstSpringBootRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyFirstSpringBootRestApplication.class, args);
	}

}
