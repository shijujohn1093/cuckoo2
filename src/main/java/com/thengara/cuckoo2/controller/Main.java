package com.thengara.cuckoo2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class Main{

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}


@RestController
class TestController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@RequestMapping("/test")
	public String test(){
		return "Success !! "+appName;
	}
	
	
}

@RefreshScope
@RestController
class ConfigController {

    @Value("${spring.cloud.config.uri}")
    String url;
	
	@Value("${message:Hello default}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message+ " "+url ;
	}
}

