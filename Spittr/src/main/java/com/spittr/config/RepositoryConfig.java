package com.spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

import com.spittr.Spitter;

public class RepositoryConfig extends RepositoryRestMvcConfiguration {
	 @Override
	    protected void configureRepositoryRestConfiguration(
	            RepositoryRestConfiguration config) {
	        config.exposeIdsFor(Spitter.class);
	    }
}
