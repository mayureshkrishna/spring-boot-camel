/**
 * 
 */
package com.cox.bis.customer.comments.route;

/**
 * @author mkrishna
 *
 */
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cox.bis.customer.comments.bean.CommentsProcessor;


@SpringBootApplication
@ComponentScan("com.cox.bis.customer.comments.bean")
public class CustomerCommentsRB extends SpringBootServletInitializer {

    public static void main(String[] args) {
    	SpringApplication.run(CustomerCommentsRB.class, args);
    }

    @Bean
    ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(
            new CamelHttpTransportServlet(), "/customer/account/v1/*");
        servlet.setName("CamelServlet");
        return servlet;
    }
	
    @Component
    class CustomerCommentsRoute extends RouteBuilder {
    
        @Override
        public void configure() throws Exception {
        	
    		 restConfiguration()
             .contextPath("/customer/account/v1").apiContextPath("/api-doc")
                 .apiProperty("api.title", "Camel REST API")
                 .apiProperty("api.version", "1.0")
                 .apiProperty("cors", "true")
                 .apiContextRouteId("doc-api")
             .bindingMode(RestBindingMode.json);

         rest("/comments/search").description("Comments Search REST service")
             .get("/").description("The list of all the books")
                 .route().routeId("comments-search-api")
                 .to("direct:commentsSearch-route")
                 .endRest();
    		
    		//Resource: CommentsProcessor
    		// Operation: commentsSearch
    		from("direct:commentsSearch-route")
    			.routeId("commentsSearch-route").description("commentsSearch-route")
    			.bean(CommentsProcessor.class,"search")
    			;
        }
    }
}