package com.demo;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired   
	private MessageSource messageSource;
	
	// using get method and hello-world URI
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}

	// internationalization
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(
			@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		System.out.println(locale.getDisplayLanguage());
		return messageSource.getMessage("good.morning.message", null, locale);
	}
	
	@GetMapping(path = "/hello-world-internationalized-context")
	public String helloWorldInternationalizedWithLocaleContext() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
}
