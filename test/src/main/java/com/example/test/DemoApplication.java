package com.example.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
		log.info("Level INFO"); 
		log.warn("Level WARN"); 
		log.error("Level ERROR");
		log.trace("Level TRACE"); 
		log.debug("Level DEBUG");
	}

}
