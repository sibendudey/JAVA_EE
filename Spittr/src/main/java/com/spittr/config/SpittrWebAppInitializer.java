package com.spittr.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected String[] getServletMappings()	{
		return new String[] { "/"  };
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses()	{
		return new Class<?>[] { RootConfig.class , MongoConfig.class };
	}

	@Override	
	protected Class<?>[] getServletConfigClasses()	{
		return new Class<?>[] { WebConfig.class };
	}
	
	@Override
	protected void customizeRegistration( Dynamic registration)	{
		registration.setMultipartConfig(new MultipartConfigElement("/tmp/spittr/uploads" , 2097152 , 4194304 , 0));
	}
}
