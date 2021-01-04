package com.hari.sprintMasterClass;

import java.util.Arrays;

public class LinearSort implements SortAlgorithm {
	
	private boolean verbose;
	
	public int[] sort(int[] numbers, boolean vbse) {
		
		verbose = vbse;
		
		Arrays.sort(numbers);
		
		return numbers;
	}
}
