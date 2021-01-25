package com.hari.springMasterClass;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hari.springMasterClass.xml.XmlPersonDAO;

//@Configuration
//@ComponentScan("com.hari.springMasterClass")
public class SprintMasterClassXMLContextApplication {

	public static void main(String[] args) {
		
//		boolean verbose = false;
		
		// We want to avoid manually creating the two beans below.
		// Since we have annotated both classes, we would want the Spring Application Context
		// to manage these beans. We need to retrieve the bean from the Spring Application Context.
		
		// Instead of this ...
//		SortAlgorithm sortAlgorithm = new LinearSort();
//		BinarySearch binSearch = new BinarySearch(verbose, sortAlgorithm);
		
		// We retrieve the beans from the Spring Application Context.
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applcationContext.xml");
//		ConfigurableApplicationContext applicationContext =	SpringApplication.run(SprintMasterClassBasicApplication.class, args);
		XmlPersonDAO xmlPersonDAO = applicationContext.getBean(XmlPersonDAO.class);
		System.out.println(xmlPersonDAO);
		System.out.println(xmlPersonDAO.getXmlJdbcConnection());

		
		applicationContext.close();
	}
}
