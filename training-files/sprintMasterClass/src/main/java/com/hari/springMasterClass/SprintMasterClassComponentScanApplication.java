package com.hari.springMasterClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hari.componentscan.ComponentPersonDAO;

@Configuration
@ComponentScan("com.hari.componentscan")
public class SprintMasterClassComponentScanApplication {

	// We want to use a logger instead of always printing out to the console.
	// We need the variable to be static, since we want to use it in the main static method.
	// static variable are all capital.
	private static Logger LOGGER = LoggerFactory.getLogger(SprintMasterClassComponentScanApplication.class);
	
	public static void main(String[] args) {
		
		// We retrieve the beans from the Spring Application Context.
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(SprintMasterClassComponentScanApplication.class, args);
		
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SprintMasterClassComponentScanApplication.class);

		ComponentPersonDAO componentPersonDao = applicationContext.getBean(ComponentPersonDAO.class);
		
		LOGGER.info("{}", componentPersonDao);
	}
}
