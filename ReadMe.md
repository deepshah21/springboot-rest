## rest services.
interaction with application-to-application.
should allow communication over network

Service Definition:
    1. Request/Response format
    2. Request Structure
    3. Response Structure
    4. Endpoint
        Create a User - POST /users
        Delete a User - DELETE /users/1
        Get all Users - GET /users
        Get one Users - GET /users/1

Transport --> HTTP and MQ
Type of services 
    1--SOAP based(simple object acess protocol,Restriction toxml)               
    2--REST-styled(Architectural, REpresentational State Transform,HTTP method and status of Resource)


spring boot auto configure dispatcher servlet
dispatcher servlet is the first who handling the request 
this is following the pattern called front controller , and dispatcher servlet knows all the mapping (path to method maping)
httpMessageConvertersAutoConfiguration --> covert response to json
jackson2ObjectMapperBuilderCustomizerConfigurations --> covert object into JSON

## RestController interface itself has annotated with ResponseBody

# exception handling

## Exception handling in Rest APIs
    1. create Custom Exception with @ResponseStatus(HttpStatus.NOT_FOUND) with proper header.
    2. throw it from the controller.
    3. It will be automatically handle in the response with status code.

To create Generic Exception extends ResponseEntityExceptionHandler
use @ControllerAdvice annotation : used when we have multiple controller classes and share resources among them . -- ExceptionHandling, ModelAttribute

# validation
to validate pojo with @RequestBody, use @Valid from javax.validation and in the pojo use javax.validations on fields (name)--> @Size(min=2,message = "size should atleast 2")
as we implemented generic exception response we nees to extends ResponseEntityExceptionHandler
we have to override handleMethodArgumentNotValid method with our 
ExceptionResponse pojo --> (date,message,discriptions)
to get discriptions --> ex.getBindingResult().toString()

## HATEOAS (hyper media as the engine of application server)
implementation 'org.springframework.boot:spring-boot-starter-hateoas'
provides easily adds links to methods
 
for example :- /users, /users/1, /users/1/posts/1 can be change to different path and as it is the hardcoded we need to change through whole application.

Resource
ControllerLinkBuilder.

if you want to additional data links use heteoas.
so here instead of sending the data in response we send resource(multiple usefull links) with data

## advance REST services

    1. internationalization : i18
        ### Configuration :-
            -LocaleResolver
        import org.springframework.web.servlet.LocaleResolver package while importing LocaleResolver.
                - Default Locale -local.US
            - DefaultBundleMessageResource

    @Bean
	public org.springframework.web.servlet.LocaleResolver localeResolver() {
		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

    create messages.properties,messages_fr.properties

        ### usage :-
            -Autowire MessageResource in controller in method body add below lines
            @RequestHeader(value = "Accept-language",required=false) Locale locale
            -messageResource.getMessage("HelloWorld.message",nul,locale);


            @RequestHeader will be replace with -> LocaleContextHolder.getLocale()
            and use AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();


    2. content negotiations
        add jackson-xml depenedcy and through request header response will be converted into xml/JSON

    3. Documentation 
        install swagger2 and swagger2 ui 
        configure bean for the swageer
        /v2/api-docs

        use @ApiModel and @ApiModelProperty annotation on POJO to provide more description in validation

    4.  monitoring -- Actuator
    spring-boot-starter-actuator
    spring-data-rest-hal-browser

    /actiator
    /application
    http://localhost:8080/explorer/index.html#uri=/


    4. filter
        4.1 static filtering
            if in pojo --> we don't want DOB ,
            @JsonIgnore --> 
            @JsonIgnoreProperties({"f1"})
        4.2 dynamic filtering
            @GetMapping("/filtering")
            public MappingJacksonValue retriveSomeBean() {
                SomeBean someBean = new SomeBean("v1","v2","v3");
                SimpleBeanPropertyFilter sf = SimpleBeanPropertyFilter.
                        filterOutAllExcept("f1");
                FilterProvider filter = new SimpleFilterProvider()
                        .addFilter("SomeBeanFilter", sf); 
                MappingJacksonValue mapping = new MappingJacksonValue(someBean);
                mapping.setFilters(filter);
                return mapping;
            } 


    5. versioning
        5.1 uri versioning
            /v1/person
            /v2/person

        5.2 request param versioning
            /person?version=1    @GetMapping(value="person", params="version=1")
            /person?version=2    @GetMapping(value="person", params="version=2")
            
        5.3 header versioning
            /person  headers (X-API-version=1)  @GetMapping(value="person", headers="X-API-version=1")
            /person  headers (X-API-version=2)  @GetMapping(value="person", headers="X-API-version=2")

        5.4 produces versioning
		/person  headers (Accept=com.v1+json)  @GetMapping(value="person", produces="application/com.v1+json")
		/person  headers (Accept=com.v2+json)  @GetMapping(value="person", produces="application/com.v1+json")

    factors
        1. URI pollution
        2. Misuse of HTTP headers
        3. Caching
        4. Can we execute the request in browser
        5. API documentation            

## Richardson maturity model : 
add urls on the basis of what users can action after getting the response

## Authentication in REST services

## Introduction to JPA
