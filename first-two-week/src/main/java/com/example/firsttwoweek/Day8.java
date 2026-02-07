package com.example.firsttwoweek;

/**
 * send an email to me : pengfei.yao@antra.com
 * includes: your time zone.
 * today is the last day
 *
 * @Configuration : tells spring that this class contains one or more bean definitions> class level annotation
 *
 *
 * @Bean: Method level annotation within configuration annotation class. spring runs method and knows this method will return a bean
 *
 * when you customized your own bean, you may need to inject some properties from other file.
 * @ConfigurationProperties: allows you to map a whole group of properties from your application.properties...
 * @Value: alternative way for  ConfigurationProperties. you could use this annotation for each one.
 *
 * my.database.timeout = 60
 * my.database.name = mysql
 * ...
 * @Configuration
 * @ConfigurationProperties(prefix =  "my.database")
 * public class Mydatabase{
 *     private String databaseName;
 *     private int timeout;
 * }
 *
 * @Service
 * public class myService{
 * @Value("${my.database.name}")
 * private String databaseName;
 *
 * @Value("${my.database.timeout}")
 * private int timeout;
 *
 * the business logic layer                 data access layer            controller layer                       exception layer             general layer
 * @Service                                     @Repository                 @Controller/ restcontroller         RestControllerAdvice        @component
 *
 * can we use component annotation to service and repository layers? YES!! you can do it.
 *  component annotation is parent annotation
 *  service and repository is child
 *
 *  restcontrolleradvice : the global watchman
 *
 *  ExceptionHandler:inside your exception class. you define methods to hand specific exception
 *
 *  Spring AOP
 *  AOP: aspect - oriented programning
 *
 * Aspect
 *  it is just a class that does not belong to your business logic code.
 *  it contains methods and pointcut and advice.
 *  this is class level annotation
 *
 *    ## Advice: it represents the action taken by an aspect at a particular join point.
 *  *  it specifies what needs to be done and when it should be applied.
 *  * @Before: runs your aspect before the method executes
 *  * @AterReturning runs after the method completes successfully
 *  * @Ater: runs regardless of the outcome
 *  * @Around : it wraps the method, allowing you to control whether it even runs, used for transaction manangement.
 *
 *
 *  pointcut: an expression that matches one or more joinpoints: it defines the specific methods or location in the code where
 *  advice should be applied
 *
 *  one pointcut is join point
 *  but one join point is not one pointcut
 *
 *  join point: your execution method that is running now, you can get method name, param....
 * @Aspect
 * @Component
 *  public class LoggingAspect{
 *
 *      private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class)
 *
 *
 *      //this pointcut
 * @pointcut("within(com.unicourse.review_service.controller)")
 * public void controllerLogging(){}
 *
 * @Before // advice
 * public void loggingBeforeControllerAPICalled(JoinPoint joinPoint){
 * logger.info("Before each api call (methods): ", joinPoint.getSignature())
 *
 * }
 *
 * @After
 * public void loggingAfterControllerAPICalled(JoinPoint joinPoint){
 *   logger.info("After each api call (methods): ", joinPoint.getSignature())
 *
 *   }
 *
 *
 *
 *
 *
 *  }
 *
 *
 * JDBC
 *  Java api for connection database, it requires you to write raw sql and MANUALLY map the results (data from database) into your java objects
 *  how it works:
 *      1: you open a connection
 *      2: write sql
 *      3: execute it
 *
 *  pros: total control over the sql.
 *  cons: you need write a lot of  boilerplate code like opening connection / closing connection. handling sqlexception...
 *
 *  Spring data JPA
 *  it allows you to interact with your database with java object(entities) rather than sql string
 *  how it works: you define an interface that extends jpa repository
 *  pros: reduction in coding, you dont have to code query method...
 *  cons: sometime can be slower (lazy loading)
 *
 *
 *  when to use which?
 *  using JPA:
 *      most of your sample project that has standard business logic, you can use this.
 *   using JDBC
 *      if you want to process complex sql query, manange your connection, you can use this.
 *
 *
 *  what are diff ORM, JPA and hibernate
 *  ORM: the concept of connecting java object to the your database(relational)
 *  JPA: the specification or like rule book
 *  it is just a set of interfaces and guidelines.  you can use it to define how things should work like you can use
 * @Entity, @Id @Table annotation.
 *
 *
 *  Hibernate(the implementation)
 *      it is the actual engine that does the heavy lifting
 *
 *      Hibernate implements the jpa,
 *
 *
 *
 *   relationships for different entities
 * @OneToOne: one studnet has one profile
 * @OneToMany / ManyToOne: one student has many classes, one class has many student
 * @ManyToMany: Many student has many classes
 *
 *
 * when we are using jpa, how can you load / fetch data from your database
 * 1: eager loading
 *          grabs everything at once in the initial query;
 *          table: Author, and book
 *          you want to list of 50 authors and each author has 10 books
 *          you are pulling 50 * 10 = 500 records into memory
 * 2: lazy loading
 *      grabs only the parent records
 *      if you want to list of authors, you just load 50 authors and load books info util you call author.getBooks();
 *
 *      N+1 problem
 *      the 1 query : select * from author (return 50 authors)
 *      the N query: hibernate sees you need books for each author, so it runs 10 times for each author ->the total number of execution is 10 * 50 = 500
 *
 *      the final total number of execution is 500 + 1
 *
 *
 *      the entity manager class is the core API of JPA
 *      it's like a gateway between your java object and the database
 *      it manages the lifecycle of enetities
 *      it provides methods to query, insert, delete, update....
 *
 *      four states;
 *      new: it is not associated with any database
 *      JPA does know about it yet
 *      if you change its values, nothing happens in the database
 *
 *      if you call persist() on itn, it becomes managed
 *
 *      managed(persistent)
 *      the entity is now under entity manage control
 *          it is tied to a row in database
 *
 *
 *       3: detached
 *          the entity was once managed but it no longer tracked
 *          changes to it will  not be saved
 *       4: removed
 *       the entity is marked for deletion...
 *
 *
 *       entity manager is low level control comparing to JPA
 *
 *
 *      driver manager in JDBC
 *      this is the lowest level.
 *      we have two classes in JDBC
 *      1: driver manager
 *          manage database driver like mysql, oracle,...give you a connection object when you want to talk to a database
 *
 *
 *          Class.forName("jdbc.driver")
 *          Connection conn = DriverManager.getConnection("your Jdbc path", "username", "password")
 *          to write sql:
 *              Statement stmt = conn.createStatement()
 *              ResultSet rs= smt.executeQquery("selct * from author")


 *
 *       2: dataSource
 *          it is a better alternative to driver manager
 *          you can ask a adata source for a connection.. data source will create connection pool for your:
 *
 *
 *
 *          
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * }
 *
 *
 */
public class Day8 {
}
