package com.cubic.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.cubic.rest.resources.HelloWorld;
import com.cubic.rest.resources.PatientResource;
import com.cubic.rest.resources.provider.GenericProvider;
import com.cubic.rest.resources.provider.InvalidDataProvider;
import com.cubic.rest.resources.provider.PatientNotFoundProvider;

@Configuration
public class RestConfig extends ResourceConfig {

	public RestConfig() {
		this.register(HelloWorld.class);
		this.register(PatientResource.class);
		this.register(GenericProvider.class);
		this.register(InvalidDataProvider.class);
		this.register(PatientNotFoundProvider.class);
		//this.packages("com.cubic.rest.resources.provider");
	}
	
}
