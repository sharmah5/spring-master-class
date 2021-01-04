package com.hari.sprintMasterClass;

public class BinarySearch {

	private boolean verbose;
	private SortAlgorithm sortAlgorithm;
	
	public BinarySearch(boolean verbose, SortAlgorithm sortAlgorithm) {
		super();
		this.verbose = verbose;
		this.sortAlgorithm = sortAlgorithm;
	}

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
}
