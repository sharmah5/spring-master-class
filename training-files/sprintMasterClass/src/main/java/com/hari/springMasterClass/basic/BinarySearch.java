package com.hari.springMasterClass.basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BinarySearch {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private boolean verbose = false;
	
	@Autowired
	@Qualifier("linear")
	private SortAlgorithm sortAlgorithm;
	
	// We can remove the constructor and the auto wiring will still be performed.
//	public BinarySearch(SortAlgorithm sortAlgorithm) {
//		super();
//		this.sortAlgorithm = sortAlgorithm;
//	}

	public SortAlgorithm getSortAlgorithm() {
		return sortAlgorithm;
	}

	// Even the setter is not required to perform auto wiring.
//	public void setSortAlgorithm(SortAlgorithm sortAlgorithm) {
//		this.sortAlgorithm = sortAlgorithm;
//	}

	private void arrayPrinter(int[] array, int lowerBound, int upperBound) {
		if (this.verbose) {
			System.out.print("[");
			
			for (int i = lowerBound; i <= upperBound; i++) {
				System.out.print(array[i]);
				if (i != upperBound) {
					System.out.print(",");
				}
			}
			
			System.out.print("]");
		}
	}
	
	// Returns true if list of integers is sorted.
	private boolean checkSorted(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}
	
	private int binarySearchHelper(int[] numbers, int leftIndex, int rightIndex, int numToSearch) {
		if ((rightIndex - leftIndex) >= 0) {
			int midIndex = (int) Math.floor((rightIndex - leftIndex) / 2) + leftIndex;
			
			if (numbers[midIndex] == numToSearch) {
				return midIndex;
			} else if (numbers[midIndex] > numToSearch) {
				arrayPrinter(numbers, leftIndex, midIndex - 1);
				
				return binarySearchHelper(numbers, leftIndex, midIndex - 1, numToSearch);
			} else {
				arrayPrinter(numbers, midIndex + 1, rightIndex);

				return binarySearchHelper(numbers, midIndex + 1, rightIndex, numToSearch);
			}
		} else {
			return -1;
		}
	}
	
	public int binarySearch(int[] numbers, int numToSearch) {
		
		//Step 1: Sort the array
		//Step 2: Search the array for the number
		//Step 3: Return the index of the number in the array
		if (!checkSorted(numbers)) {
			int[] sortedList = sortAlgorithm.sort(numbers, this.verbose);
			System.out.println(sortAlgorithm);
			
			System.out.println("Searching list.");
			arrayPrinter(numbers, 0, numbers.length - 1);
			
			return binarySearchHelper(sortedList, 0, numbers.length - 1, numToSearch);
		} else {
			System.out.println("Searching list.");
			arrayPrinter(numbers, 0, numbers.length - 1);
			
			return binarySearchHelper(numbers, 0, numbers.length - 1, numToSearch);
		}
	}
	
	@PostConstruct
	public void postConstruct() {
		logger.info("postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() {
		logger.info("preDestroy");
	}
}
