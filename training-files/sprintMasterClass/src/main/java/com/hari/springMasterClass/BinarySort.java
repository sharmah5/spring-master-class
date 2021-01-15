package com.hari.springMasterClass;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("binary")
public class BinarySort implements SortAlgorithm {

	private boolean verbose;
	
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
	
	public int[] sort(int[] numbers, boolean vbse) {
		verbose = vbse;
		
		System.out.println("Sorting list.");
		
		if (numbers.length <= 1) {
			return numbers;
		}
		
		return binarySortHelper(
				Arrays.copyOfRange(numbers, 0, (int) Math.floor(numbers.length / 2)), 
				Arrays.copyOfRange(numbers, (int) Math.floor(numbers.length / 2), numbers.length));	
	}
}
