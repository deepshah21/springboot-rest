package com.demo;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	// dynamic filtering
	@GetMapping("/filtering")
	public MappingJacksonValue retriveSomeBean() {
		SomeBean someBean = new SomeBean("v1","v2","v3");
		SimpleBeanPropertyFilter sf = SimpleBeanPropertyFilter.
				filterOutAllExcept("f1");
		FilterProvider filter = new SimpleFilterProvider().addFilter("SomeBeanFilter", sf); 
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filter);
		return mapping;
	}
	
	// static filtering
	@GetMapping("/staticfiltering")
	public StaticSomeBean retriveStaticSomeBean() {
		return new StaticSomeBean("v1","v2","v3");
	}
}
