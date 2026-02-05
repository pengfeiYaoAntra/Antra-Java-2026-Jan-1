package com.example.firsttwoweek;

/**
 *  Please send your private email to me again, we will the link this week/ next Monday.
 *  we do not have the meeting this Feb 6
 *  the evaluation is Feb 10th. (Next Tue)
 *  Everyone should have 30 mins for evaluation
 *  my email: pengfei.yao@antra.com
 *  
 *  
 *  Spring MVC
 *  M: model: your business logic happens here
 *
 *      
 *  V: view: rendering the data from the model to the user: HTML
 *
 *  C controller
 *      handles user input and updates the model and view accordingly.
 *
 *
 *   Our project starter:
 *      @SpringBootApplication: this allows to start your spring boot project.
 *
 *      @SpringBootConfiguration
 *          this is the heart of you application,
 *          it identifies the class as source of bean definitions.
 *      @EnableAutoConfiguration
 *              springboot will think like this: oh I see your have many dependencies like spring boot starter web
 *                  I will automatically set up a Tomcat server and dispatcher servlet.
 *                  I also see you database driver here. I will try to load it.
 *      @ComponentScan
 *          this tells spring boot where to look for your @Component, @Service, @Repository and @Controller (@RestController) classes
 *          by default, it scans the package the main class is in and all sub-package
 *
 *
 * @restController
 * what it does?
 *  it tells spring that this class is  a web component and that return value of every method should be written directly into
 *  http response body (like JSON)
 *  RequestMapping
 *  it is a router. it maps specific web path to your java methods
 *
 * @GetMapping
 *  retrieve data  from the server
 * @PostMappting
 *  create a NEW resource on the server
 *
 * @PutMapping
 * update an existing resource on the server
 *
 * @PatchMapping...
 * partially update an existing resource on the server.
 *
 * ReponseEntity
 *  it allows you to control the entire http response: you can set your own http status code, header and body.
 *
 *  Restcontroller and controller annotation
 *  controller : the traditional way
 *      it is used for server side rendering
 *      it return html (a view)
 *      websites where the server handles the UI
 *   restcontroller: it is not server side rendering. it returns json data ( not a view)
 *      converts your java objects into Json (XML) and writes them into the http response body.
 *      restful apis, single page application(react, vue, angular)
 *
 *
 *      controller steps
 *          user's request ->   dispatcher servlet  -> step 1 ->  handler mapping (tells which controller you need to go) -> send info back dispatcher servlet
 *                                                  -> step 2->  request to controller -> return info back to dispatcher servlet
 *                                                  -> step 3 -> View resolver - resolve the view that returns from your controller -> send info back to dispatcher servlet
 *                                                  -> step 4 -> View -> rendering your view. -> return view to user
 *
 *       rest controller steps:
 *       user's request ->   dispatcher servlet  -> step 1 ->  handler mapping (tells which controller you need to go) -> send info back dispatcher servlet
 *  *                                            -> step 2->  request to rest controller -> return info back to dispatcher servlet -> return data to user
 *
 *
 *      What is Json?
 *      key -value format. key must be string, and value can be array, string number, null , true  and false
 *      {
 *          'car':"BMW",
 *          'year':2026
 *      }
 *      what is dispatcher servlet
 *      it acts as the single entry point for every single http request hitting your server.
 *
 *      Filter vs Interceptors
 *
 *      Filter location: user 's request -> filter -> dispatcher servlet
 *      they catch the request before it ever reaches the dispatcher servlet
 *      best for authentication, logging, encryption and compression
 *
 *      Interceptors
 *      they sit between dispatcher servlet and your controller level
 *      they only handle requests that are mapped to spring controller
 *
 *          best for authorization : you can do with interceptor : checking if user has some permissions
 *
 * delete..
 *
 *
 *      Path variable: this is sued to extract values from URL path
 *      syntax /api/car/{id}
 *
 *      Requestparam
 *      this extracts values from the query string (the part after the "?" in a URL)
 *      Syntax /api/search?car=BMW&year=2026
 *
 *      RquestBody
 *      it extracts json body from http body and convert it into a java object (not URL)
 *
 *
 *
 *      Spring IOC
 *      IOC : inversion of control.
 *      you give up control. you stop using the "new" keyword in java for creating an object.
 *      you tell spring: hi there, I am gonna need a database connection bean, you(IOC) go to create it and manage it
 *      and just give it to me when I need it.
 *
 *      the container:  pool of objects, we called beans
 *      example like: you container that has M&M beans
 *
 *      bean vs object
 *      bean is managed by spring ioc, whereas object is managed by JVM(GC)
 *
 *      how to print beans
 *      ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(ConfigServerApplication.class, args);
 * 		String[] names = configurableApplicationContext.getBeanDefinitionNames();
 * 		for(String name : names){
 * 			System.out.println(name);
 * 		        }
 *
 *
 *
 * 	 how IOC is achieved : DI(dependency injection)
 * 	 ioc is the design principle, and Di is the pattern > used to implement it
 *
 * 	 1: constructor injection
 * 	 this is the most recommended way  in modern spring,
 * 	 spring boot looks at the constructor and searchs the application context(ioc container) for beans .
 *
 *
 * 	    ReviewController{
 * 	            private final ReviewService reviewService; -> this is  immutable!!! they can not change after the class is created.
 * 	            public ReviewController(ReviewService reviewService){
 * 	                this.reviewService = reviewService;
 * 	            }
 * 	    }
 *
 *
 * 	  2: setter injection
 * 	  you provide setter method for creating beans
 * 	  use this for option al dependencies.
 * 	  ReviewController{
 *
 * 	      private ReviewService reviewService;
 *
 * @Autowired
 * public void setReview(ReviewService reviewService){
 *     this.reviewService = reviewService
 * }
 * 	  }
 *
 * 	  Field injection
 * 	  putting @autowired directly on the private variable
 *
 * 	  ReviewController{
 *  * 	      @Autowired
 *  * 	      private ReviewService reviewService;}
 *
 *
 * Method injection
 * it used to solve the problem like: injecting a prototype bean into a singleton bean.
 *      bc if you are not using this way injection and you injecting a prototype bean into a singleton bean.
 *      your prototype beans won't change anymore, just like singleton bean.
 *
 *
 *
 *
 * what are ways we can inject beans
 * two annotations
 * 1: autowired : it is used to automatically wire dependencies ***by type***
 * 2: qualifier: used to resolve confusion when there are multiple beans of the same type avaiable for injection
 *                  this injects beans **by value**
 *
 *
 * interface SoftwareEng{
 *     SayHello()
 * }
 * @Component("Java")
 * class JavaDeveloper implements softwareEng{
 *     override
 *     sayHello(){....your implements}
 * }
 * @Component("React")
 * class ReactDeveloper implements softwareEng{
 *     override
 *     sayHello(){....your implements}
 * }
 *
 * you have service, you want to inject softwareEng bean into your service layer
 * @Service
 * class JavaDeveloperService{
 * @Autowired
 * SoftwareEng softwareEng;  -> you will receive an exception.
 * }
 *
 * @Service
 *  * class JavaDeveloperService{
 *  * @Autowired
 * @Qualifier("Java")
 *  * SoftwareEng softwareEng;  -> solve exception.
 *  * }
 *
 *
 * Bean scope: defines the lifecycle and visibility of a bean within the ioc container
 * singleton (default) -> spring creates only one instances of the bean per container.
 *
 * Prototype
 * this is the "new one every time" scope. spring creates a new instance every single time the bean is requested from the container.
 *
 * Web - aware scopes
 * request scope -  A new instance is created for every single HTTP request
 * one request is finished and response is sent, then bean is destroyed
 *
 *  session scope
 *      A new instance is created for every http session. bean lives as long as the user's session is active.(usually when you close your web, then bean is deleted)
 * @Serive
 * @Scope("prototype")
 * public class ReviewService{
 *
 *
 * }
 *
 *
 *      what are bean life cycle
 *          1: instantiation: spring finds the bean definition and creates the java object like calling new MyBean()
 *          2: populating properties: spring performs DI (injecting your beans )
 *          3: initialization: this is where the bean  is ready to use.
 *          4: destruction: spring cleans up the beans.
 *
 *
 *
 */

public class Day7 {
}
