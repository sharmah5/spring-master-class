package com.hari.sprintMasterClass;

import java.util.Arrays;

public class BinarySearch {

	private static boolean verbose = false;
	
	private void arrayPrinter(int[] array, int lowerBound, int upperBound) {
		if (verbose) {
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
	
	// Returns sorted list of integers from two smaller lists of integers
	private int[] binarySortHelper(int[] numbers1, int[] numbers2) {
		
		// If both smaller lists are of length 1, return sorted list with two integers
		if(numbers1.length == 1 && numbers2.length == 1) {
			if (numbers1[0] < numbers2[0]) {
				arrayPrinter(new int[] {numbers1[0], numbers2[0]}, 0, 1);

				return new int[] {numbers1[0], numbers2[0]};
			} else {
				arrayPrinter(new int[] {numbers2[0], numbers1[0]}, 0, 1);

				return new int[] {numbers2[0], numbers1[0]};
			}
		} else {
			int[] leftSortedArray;
			int[] rightSortedArray;
			int[] sortedList = new int[numbers1.length + numbers2.length]; 
			
			// If first list is of length 1, return first list.
			if (numbers1.length == 1) {
				leftSortedArray = numbers1;
			// Otherwise call binarySortHelper by dividing first list in two
			} else {
				leftSortedArray = binarySortHelper(
						Arrays.copyOfRange(numbers1, 0, (int) Math.floor(numbers1.length / 2)), 
						Arrays.copyOfRange(numbers1, (int) Math.floor(numbers1.length / 2), numbers1.length));
			}
			
			// If second list is of length 1, return second list.
			if (numbers2.length == 1) {
				rightSortedArray = numbers2;
			// Otherwise call binarySortHelper by dividing second list in two
			} else {
				rightSortedArray = binarySortHelper(
						Arrays.copyOfRange(numbers2, 0, (int) Math.floor(numbers2.length / 2)), 
						Arrays.copyOfRange(numbers2, (int) Math.floor(numbers2.length / 2), numbers2.length));
			} 
			
			
			// Sort two lists and return sorted list
			int leftListIndex = 0;
			int rightListIndex = 0;
			
			for (int i = 0; i < leftSortedArray.length + rightSortedArray.length; i++) {
				
				// Append rightSortedArray to sortedList if reached end of leftSortedArray
				if (leftListIndex == leftSortedArray.length) {
					for (int j = rightListIndex; j < rightSortedArray.length; j++) {
						sortedList[leftListIndex + j] = rightSortedArray[j];
					}
					break;
				
				// Append leftSortedArray to sortedList if reached end of rightSortedArray
				} else if (rightListIndex == rightSortedArray.length) {
					for (int j = leftListIndex; j < leftSortedArray.length; j++) {
						sortedList[rightListIndex + j] = leftSortedArray[j];
					}
					break;
				
				// Compare elements between left and right lists
				} else {
					if (leftSortedArray[leftListIndex] < rightSortedArray[rightListIndex]) {
						sortedList[leftListIndex + rightListIndex] = leftSortedArray[leftListIndex];
						leftListIndex++;
					} else {
						sortedList[leftListIndex + rightListIndex] = rightSortedArray[rightListIndex];
						rightListIndex++;
					}
				}	
			}
			
			arrayPrinter(sortedList, 0, sortedList.length - 1);
			
			return sortedList;
		}
			
	}
	
	private int[] binarySort(int[] numbers) {
		System.out.println("Sorting list.");
		
		if (numbers.length <= 1) {
			return numbers;
		}
		
		return binarySortHelper(
				Arrays.copyOfRange(numbers, 0, (int) Math.floor(numbers.length / 2)), 
				Arrays.copyOfRange(numbers, (int) Math.floor(numbers.length / 2), numbers.length));	
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
			int[] sortedList = binarySort(numbers);
			
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
