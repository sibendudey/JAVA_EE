package com.spittr.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles2.TilesConfigurer;
import org.springframework.web.servlet.view.tiles2.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("spittr.web")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setExposeContextBeansAsAttributes(true);
		return resolver;
	}
	
	/*@Bean
	public ViewResolver viewResolver()	{
		return new TilesViewResolver();
	}
	
	@Bean
	public TilesConfigurer tilesConfigurer()	{
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[]	{
				"/WEB-INF/layout/tiles.xml"
		});
		return tiles;
	}*/

	@Bean
	public ResourceBundleMessageSource messageSource()	{
		ResourceBundleMessageSource source = new ResourceBundleMessageSource();
		source.setBasename("messages/ValidationMessages");
		return source;
	}
	@Override
	public void configureDefaultServletHandling(
	DefaultServletHandlerConfigurer configurer) {
	configurer.enable();
	}
	
	/*@Override
	public void addResourceHandlers( final ResourceHandlerRegistry registry)	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}*/
	
}
	
