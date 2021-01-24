package com.hari.springMasterClass;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.hari.springMasterClass.basic.BinarySearch;

@Configuration
@ComponentScan("com.hari.springMasterClass")
public class SprintMasterClassBasicApplication {

	public static void main(String[] args) {
		
//		boolean verbose = false;
		
		// We want to avoid manually creating the two beans below.
		// Since we have annotated both classes, we would want the Spring Application Context
		// to manage these beans. We need to retrieve the bean from the Spring Application Context.
		
		// Instead of this ...
//		SortAlgorithm sortAlgorithm = new LinearSort();
//		BinarySearch binSearch = new BinarySearch(verbose, sortAlgorithm);
		
		// We retrieve the beans from the Spring Application Context.
		ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(SprintMasterClassBasicApplication.class);
//		ConfigurableApplicationContext applicationContext =	SpringApplication.run(SprintMasterClassBasicApplication.class, args);
		BinarySearch binSearch = applicationContext.getBean(BinarySearch.class);
		
		// Spring beans are created as singletons. This means binSearch and binSearch2 are referencing the same instance.
		BinarySearch binSearch2 = applicationContext.getBean(BinarySearch.class);
		System.out.println(binSearch);
		System.out.println(binSearch2);
		
		int indexOfInteger = binSearch.binarySearch(new int[] {1, 7, 1, 85, 0, 2, 20, 4}, 0);
		
		if (indexOfInteger == -1) {
			System.out.println("\nInteger not found.");
		} else {
			System.out.println("\nInteger found at index " + indexOfInteger + " when list is sorted.");
		}
	}
}
