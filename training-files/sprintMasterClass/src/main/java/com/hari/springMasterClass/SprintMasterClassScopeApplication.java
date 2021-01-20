package com.hari.springMasterClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.hari.springMasterClass.scope.PersonDAO;

@SpringBootApplication
public class SprintMasterClassScopeApplication {

	// We want to use a logger instead of always printing out to the console.
	// We need the variable to be static, since we want to use it in the main static method.
	// static variable are all capital.
	private static Logger LOGGER = LoggerFactory.getLogger(SprintMasterClassScopeApplication.class);
	
	public static void main(String[] args) {
		
		// We retrieve the beans from the Spring Application Context.
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SprintMasterClassScopeApplication.class, args);
		PersonDAO personDao = applicationContext.getBean(PersonDAO.class);
		PersonDAO personDao2 = applicationContext.getBean(PersonDAO.class);
		
		LOGGER.info("{}", personDao);
		LOGGER.info("{}", personDao.getJdbcConnection());
		LOGGER.info("{}", personDao.getJdbcConnection());

		LOGGER.info("{}", personDao2);
		LOGGER.info("{}", personDao2.getJdbcConnection());

	}
}
