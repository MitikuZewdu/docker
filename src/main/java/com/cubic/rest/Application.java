package com.cubic.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;







@SpringBootApplication
@ComponentScan("com.cubic.rest")
public class Application {

    @SuppressWarnings("static-access")
	public static void main(String[] args){
        new SpringApplication().run(Application.class);
    }
}
