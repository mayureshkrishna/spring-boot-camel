# CUSTOMER COMMENTS Spring Boot REST Service with Camel using Maven


### Pre-requisites

#### 1. Maven

Spring Boot is compatible with Apache Maven 3.2 or above. If you donâ€™t already have Maven installed you can follow the instructions at maven.apache.org.

#### 2. GIT Bash

On Windows, if you don't already have GIT Bash installed, download [GIT Bash here](https://git-scm.com/downloads)


## Clone Code and Run

Clone Code in a working directory using

```
$ https://github.com/mayureshkrishna/spring-boot-camel.git
```

Once you have cloned the code, you can now run the Spring Boot REST service using

```
$ mvn clean spring-boot:run
```

If you want to run with a specific environment application properties, then make sure to have a property file with environment name. For e.g. application-dev.properties
Now you can run with application-dev.properties using:

```
$ mvn clean spring-boot:run -Dspring.profiles.active=dev
```

You should see similar to following

```
[INFO] Scanning for projects...
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building Customer Comments Camel and Spring Boot 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ customer-comments ---
[INFO] Deleting C:\Data\Workspace\GITHUB\spring-boot-camel\target
[INFO] 
[INFO] >>> spring-boot-maven-plugin:1.4.2.RELEASE:run (default-cli) > test-compile @ customer-comments >>>
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ customer-comments ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 2 resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ customer-comments ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 17 source files to C:\Data\Workspace\GITHUB\spring-boot-camel\target\classes
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ customer-comments ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory C:\Data\Workspace\GITHUB\spring-boot-camel\src\test\resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ customer-comments ---
[INFO] No sources to compile
[INFO] 
[INFO] <<< spring-boot-maven-plugin:1.4.2.RELEASE:run (default-cli) < test-compile @ customer-comments <<<
[INFO] 
[INFO] --- spring-boot-maven-plugin:1.4.2.RELEASE:run (default-cli) @ customer-comments ---

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.2.RELEASE)

2017-07-11 01:51:17.610  INFO 9508 --- [           main] c.c.b.c.c.route.CustomerCommentsRB       : Starting CustomerCommentsRB on CATL0W107D70M12 with PID 9508 (C:\Data\Workspace\GITHUB\spring-boot-camel\target\classes started by mkrishna in C:\Data\Workspace\GITHUB\spring-boot-camel)
2017-07-11 01:51:17.631  INFO 9508 --- [           main] c.c.b.c.c.route.CustomerCommentsRB       : The following profiles are active: dev
2017-07-11 01:51:17.846  INFO 9508 --- [           main] ationConfigEmbeddedWebApplicationContext : Refreshing org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@6dbd6c72: startup date [Tue Jul 11 01:51:17 EDT 2017]; root of context hierarchy
2017-07-11 01:51:21.840  INFO 9508 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.apache.camel.spring.boot.CamelAutoConfiguration' of type [class org.apache.camel.spring.boot.CamelAutoConfiguration$$EnhancerBySpringCGLIB$$ce83e37f] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2017-07-11 01:51:24.270  INFO 9508 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat initialized with port(s): 8080 (http)
2017-07-11 01:51:24.303  INFO 9508 --- [           main] o.apache.catalina.core.StandardService   : Starting service Tomcat
2017-07-11 01:51:24.305  INFO 9508 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.6
2017-07-11 01:51:24.663  INFO 9508 --- [ost-startStop-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2017-07-11 01:51:24.664  INFO 9508 --- [ost-startStop-1] o.s.web.context.ContextLoader            : Root WebApplicationContext: initialization completed in 6832 ms
2017-07-11 01:51:25.120  INFO 9508 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'CamelServlet' to [/customer/comments/v1/*]
2017-07-11 01:51:25.122  INFO 9508 --- [ost-startStop-1] o.s.b.w.servlet.ServletRegistrationBean  : Mapping servlet: 'dispatcherServlet' to [/]
2017-07-11 01:51:25.137  INFO 9508 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'characterEncodingFilter' to: [/*]
2017-07-11 01:51:25.137  INFO 9508 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'hiddenHttpMethodFilter' to: [/*]
2017-07-11 01:51:25.138  INFO 9508 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'httpPutFormContentFilter' to: [/*]
2017-07-11 01:51:25.138  INFO 9508 --- [ost-startStop-1] o.s.b.w.servlet.FilterRegistrationBean   : Mapping filter: 'requestContextFilter' to: [/*]
2017-07-11 01:51:25.859  INFO 9508 --- [           main] s.w.s.m.m.a.RequestMappingHandlerAdapter : Looking for @ControllerAdvice: org.springframework.boot.context.embedded.AnnotationConfigEmbeddedWebApplicationContext@6dbd6c72: startup date [Tue Jul 11 01:51:17 EDT 2017]; root of context hierarchy
2017-07-11 01:51:25.997  INFO 9508 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error]}" onto public org.springframework.http.ResponseEntity<java.util.Map<java.lang.String, java.lang.Object>> org.springframework.boot.autoconfigure.web.BasicErrorController.error(javax.servlet.http.HttpServletRequest)
2017-07-11 01:51:25.998  INFO 9508 --- [           main] s.w.s.m.m.a.RequestMappingHandlerMapping : Mapped "{[/error],produces=[text/html]}" onto public org.springframework.web.servlet.ModelAndView org.springframework.boot.autoconfigure.web.BasicErrorController.errorHtml(javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse)
2017-07-11 01:51:26.127  INFO 9508 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-11 01:51:26.129  INFO 9508 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-11 01:51:26.196  INFO 9508 --- [           main] o.s.w.s.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**/favicon.ico] onto handler of type [class org.springframework.web.servlet.resource.ResourceHttpRequestHandler]
2017-07-11 01:51:27.490  INFO 9508 --- [           main] o.a.c.i.converter.DefaultTypeConverter   : Loaded 196 type converters
2017-07-11 01:51:27.836  INFO 9508 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-07-11 01:51:28.004  INFO 9508 --- [           main] o.a.camel.spring.boot.RoutesCollector    : Loading additional Camel XML routes from: classpath:camel/*.xml
2017-07-11 01:51:28.005  INFO 9508 --- [           main] o.a.camel.spring.boot.RoutesCollector    : Loading additional Camel XML rests from: classpath:camel-rest/*.xml
2017-07-11 01:51:28.008  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Apache Camel 2.18.2 (CamelContext: camel-1) is starting
2017-07-11 01:51:28.009  INFO 9508 --- [           main] o.a.c.m.ManagedManagementStrategy        : JMX is enabled
2017-07-11 01:51:28.282  INFO 9508 --- [           main] o.a.c.i.DefaultRuntimeEndpointRegistry   : Runtime endpoint registry is in extended mode gathering usage statistics of all incoming and outgoing endpoints (cache limit: 1000)
2017-07-11 01:51:28.735  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : StreamCaching is not in use. If using streams then its recommended to enable stream caching. See more details at http://camel.apache.org/stream-caching.html
2017-07-11 01:51:29.000  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-get-route started and consuming from: direct://commentsGet-route
2017-07-11 01:51:29.002  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-search-route started and consuming from: direct://commentsSearch-route
2017-07-11 01:51:29.004  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-search-api started and consuming from: servlet:/?httpMethodRestrict=POST
2017-07-11 01:51:29.006  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-get-api started and consuming from: servlet:/?httpMethodRestrict=GET
2017-07-11 01:51:29.006  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: comments-ping-api started and consuming from: servlet:/ping/?httpMethodRestrict=GET
2017-07-11 01:51:29.008  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Route: doc-api started and consuming from: servlet:/api-doc?httpMethodRestrict=GET&matchOnUriPrefix=true
2017-07-11 01:51:29.008  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Total 6 routes, of which 6 are started.
2017-07-11 01:51:29.009  INFO 9508 --- [           main] o.a.camel.spring.SpringCamelContext      : Apache Camel 2.18.2 (CamelContext: camel-1) started in 1.003 seconds
2017-07-11 01:51:29.296  INFO 9508 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-07-11 01:51:29.302  INFO 9508 --- [           main] c.c.b.c.c.route.CustomerCommentsRB       : Started CustomerCommentsRB in 13.467 seconds (JVM running for 31.939)
```

Now your service is up and running on localhost:8080. You can run the service at [http://localhost:8080/customer/comments/v1](http://localhost:8080/customer/comments/v1)

### REQUEST BODY - JSON
```
{"siteId":"123","accountNumber":"123456789","startDate":"2017021","endDate":"20170215","directives":null}
```

### RESPONSE BODY - JSON

```
[
  {
    "commentId": "20170214001",
    "entryDate": "20170214",
    "sequenceNumber": "001",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "XXXXXXXX"
  },
  {
    "commentId": "20170214002",
    "entryDate": "20170214",
    "sequenceNumber": "002",
    "commentLineText": "SDSDSDSDSDS SDSDSDSDSD",
    "userId": "XXXXXXXX"
  }
]
```