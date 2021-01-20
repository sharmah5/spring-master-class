package com.hari.springMasterClass.basic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("linear")
public class LinearSort implements SortAlgorithm {
	
	public int[] sort(int[] numbers, boolean vbse) {
		
		Arrays.sort(numbers);
		
		return numbers;
	}
}
