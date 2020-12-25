package com.demo;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
public class RestPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestPracticeApplication.class, args);
	}

	@Bean
	public org.springframework.web.servlet.LocaleResolver localeResolver() {
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver(); 
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	// can be set through application.properties as well
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}
	
}
