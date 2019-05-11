package com.cubic.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Path("/hello")
public class HelloWorld {

	private final static Logger logger = LoggerFactory.getLogger(HelloWorld.class);

	@GET
	public String hello() {
		logger.debug("This is test for Hello world log4j");
		return "Welcome to micorservice";
	}

}
