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
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import static org.apache.camel.model.rest.RestParamType.body;

import com.cox.bis.customer.comments.api.model.CommentsSearchRequest;
import com.cox.bis.customer.comments.api.model.CommentsSearchResponse;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class })
// @EnableAutoConfiguration
@ComponentScan("com.cox.bis")
public class CustomerCommentsRB extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CustomerCommentsRB.class, args);
	}

	@Bean
	ServletRegistrationBean servletRegistrationBean() {
		ServletRegistrationBean servlet = new ServletRegistrationBean(new CamelHttpTransportServlet(),
				"/customer/comments/v1/*");
		servlet.setName("CamelServlet");
		return servlet;
	}

	@Component
	class CustomerCommentsRoute extends RouteBuilder {

		@Override
		public void configure() throws Exception {

			restConfiguration().contextPath("/customer/comments/v1").apiContextPath("/api-doc")
					.apiProperty("api.title", "Camel REST API").apiProperty("api.version", "1.0")
					.apiProperty("cors", "true").apiContextRouteId("doc-api").bindingMode(RestBindingMode.json);

			rest("/").description("Customer Comments REST service").consumes("application/json")
					.produces("application/json").post("/").type(CommentsSearchRequest.class)
					.description("Search Customer Comment").outType(CommentsSearchResponse.class).param().type(body)
					.name("CommentsSearchRequest").description("Comments Search Request Input").endParam().route()
					.routeId("comments-search-api").to("direct:commentsSearch-route");

			rest("/").description("Customer Comments REST service").produces("application/json").get("/")
					.description("Get Customer Comments").route().routeId("comments-get-api")
					.to("direct:commentsGet-route");

			rest("/ping").description("Customer Comments Ping Resource").get("/").description("Ping Customer Comments")
					.route().routeId("comments-ping-api").to("direct:commentsPing-route");

			// Resource: CommentsProcessor
			// Operation: commentsGet
			from("direct:commentsGet-route").routeId("comments-get-route").description("commentsGet-route").to(
					"bean:commentsProcessor?method=getComments(${header.clientId},${header.siteId},${header.accountNumber},${header.sort},${header.startDate},${header.endDate},${header.max})");

			// Resource: CommentsProcessor
			// Operation: commentsSearch
			from("direct:commentsSearch-route").routeId("comments-search-route").description("commentsSearch-route")
					.to("bean:commentsProcessor?method=search");
		}
	}
}