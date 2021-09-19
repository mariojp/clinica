package br.com.med.clinica;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer { //talvez não seja necessario

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
         registry.addViewController("/").setViewName("index");
         registry.addViewController("/login").setViewName("login");
	
	
	}

}
