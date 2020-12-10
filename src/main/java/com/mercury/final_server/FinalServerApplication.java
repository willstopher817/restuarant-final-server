package com.mercury.final_server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FinalServerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		// automatically launch embedded tomcat server
		// and deploy java web app on the tomcat server
		SpringApplication.run(FinalServerApplication.class, args);
	}

	// getLogger(reference to current class)
	private final Logger LOGGER = LoggerFactory.getLogger(FinalServerApplication.class);

	@Override
	public void run(String... arg0) throws Exception {
		// run will be automatically executed after spring app starts
		// demos for logging

		// print message on console. will not be save in logging
		System.out.println("something from System.out");

		// how to print message into the log file
		// use slf4j
		LOGGER.info("some info for you to know...");
		LOGGER.debug("debugging contents...");
		LOGGER.error("error message for demo");	// try/catch
		// each log function will set logging level for the message
		// low -> high
		// TRACE, DEBUG, INFO, WARN, ERROR, FATAL, OFF
		// you can set your application logging level as L,
		// only message's logging level >= L will be written into the file
		// e.g. Application Logging: WARN
		// messages of WARN/ERROR/FATAL will be written in file
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// higher strength mean more difficult to be hacked
		return new BCryptPasswordEncoder(11);
	}

}
