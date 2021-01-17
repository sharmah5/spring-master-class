package com.hari.springMasterClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.hari.componentscan.ComponentPersonDAO;
import com.hari.springMasterClass.basic.BinarySearch;
import com.hari.springMasterClass.scope.PersonDAO;

@SpringBootApplication
@ComponentScan("com.hari.componentscan")
public class SprintMasterClassComponentScanApplication {

	// We want to use a logger instead of always printing out to the console.
	// We need the variable to be static, since we want to use it in the main static method.
	// static variable are all capital.
	private static Logger LOGGER = LoggerFactory.getLogger(SprintMasterClassComponentScanApplication.class);
	
	public static void main(String[] args) {
		
		// We retrieve the beans from the Spring Application Context.
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SprintMasterClassComponentScanApplication.class, args);
		ComponentPersonDAO componentPersonDao = applicationContext.getBean(ComponentPersonDAO.class);
		
		LOGGER.info("{}", componentPersonDao);
	}
}
