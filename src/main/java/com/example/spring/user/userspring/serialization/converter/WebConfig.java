package com.example.spring.user.userspring.serialization.converter;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	private final static MediaType MEDIATYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
	
	/*public void configurerContentNegotation(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(true)
		.parameterName("MediaType")
		.ignoreAcceptHeader(true)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("x-yaml", MEDIATYPE_APPLICATION_YML);
	}*/
	
	
	  
	public void configurerContentNegotatio(ContentNegotiationConfigurer configurer) {
		configurer.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("x-yaml", MEDIATYPE_APPLICATION_YML);
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	
		converters.add(new YamlJackson2HttpMessageConverter());
		
	}
	
}
