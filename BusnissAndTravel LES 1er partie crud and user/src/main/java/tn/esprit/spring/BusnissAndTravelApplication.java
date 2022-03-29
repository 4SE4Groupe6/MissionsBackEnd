package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;


@SpringBootApplication

public class BusnissAndTravelApplication extends DelegatingWebMvcConfiguration {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/home").setViewName("home");
	}
	public static void main(String[] args) {
		SpringApplication.run(BusnissAndTravelApplication.class, args);
	}

}
