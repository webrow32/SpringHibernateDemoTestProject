package com.benjie.spring.demo.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.benjie.spring.demo.model.Pizza;
import com.benjie.spring.demo.viewresolver.ExcelViewResolver;
import com.benjie.spring.demo.viewresolver.Jaxb2MarshallingXmlViewResolver;
import com.benjie.spring.demo.viewresolver.JsonViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.benjie.spring.demo")
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(
				MediaType.TEXT_HTML);
	}

	@Bean
	public ViewResolver contentNegotiatingViewResolver(
			ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);

		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		resolvers.add(jaxb2MarshallingXmlViewResolver());
		resolvers.add(jsonViewResolver());
		resolvers.add(jspViewResolver());
		//resolvers.add(pdfViewResolver());
		resolvers.add(excelViewResolver());

		resolver.setViewResolvers(resolvers);
		return resolver;
	}

	@Bean
	public ViewResolver jaxb2MarshallingXmlViewResolver() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Pizza.class);
		return new Jaxb2MarshallingXmlViewResolver(marshaller);
	}

	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}

//	@Bean
//	public ViewResolver pdfViewResolver() {
//		return new PdfViewResolver();
//	}
	
	 @Bean
	    public ViewResolver excelViewResolver() {
	        return new ExcelViewResolver();
	    }
	 

	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
