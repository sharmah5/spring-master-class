package com.hari.springMasterClass;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class LinearSort implements SortAlgorithm {
	
	private boolean verbose;
	
	public int[] sort(int[] numbers, boolean vbse) {
		
		verbose = vbse;
		
		Arrays.sort(numbers);
		
		return numbers;
	}
}
