package com.hari.sprintMasterClass;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprintMasterClassApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SprintMasterClassApplication.class, args);
		
		SortAlgorithm sortAlgorithm = new LinearSort();
		boolean verbose = false;
		
		BinarySearch binSearch = new BinarySearch(verbose, sortAlgorithm);
		
		int indexOfInteger = binSearch.binarySearch(new int[] {1, 7, 1, 85, 0, 2, 20, 4}, 0);
		
		if (indexOfInteger == -1) {
			System.out.println("\nInteger not found.");
		} else {
			System.out.println("\nInteger found at index " + indexOfInteger + " when list is sorted.");
		}
	}

}
