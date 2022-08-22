package com.learning.sc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class CalculatorInitializer //implements WebApplicationInitializer
{

	//@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		//XmlWebApplicationContext context = new XmlWebApplicationContext();
		//context.setConfigLocation("classpath:application-config.xml");
		
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(CalculatorAppConfig.class);
		
		// Create a DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(context);
		// registered DispatcherServlet with servlet context
		ServletRegistration.Dynamic servletRegistration  = servletContext.addServlet("myDispatcherServlet", servlet);
		
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/mywebsite.com/*");
	}

	
}
