package com.hari.springMasterClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hari.springMasterClass.xml.XmlPersonDAO;

//@Configuration
//@ComponentScan("com.hari.springMasterClass")
public class SprintMasterClassXMLContextApplication {
	
	private static Logger LOGGER = LoggerFactory.getLogger(SprintMasterClassXMLContextApplication.class);

	public static void main(String[] args) {
				
		// We retrieve the beans from the Spring Application Context.
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applcationContext.xml");
		
		// Beans Loaded -> [xmlJdbcConnection, XmlPersonDAO]
		LOGGER.info("Beans Loaded -> {}", (Object) applicationContext.getBeanDefinitionNames());
		
//		ConfigurableApplicationContext applicationContext =	SpringApplication.run(SprintMasterClassBasicApplication.class, args);
		XmlPersonDAO xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
		LOGGER.info("{}; {}", xmlPersonDAO.getClass(), xmlPersonDAO.getXmlJdbcConnection());;
		
		applicationContext.close();
	}
}
