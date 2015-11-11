package com.cei37.test;

import java.util.ArrayList;
import java.util.List;

public class JoinTwoSortedArrays {

	/**
	 * Join two sorted arrays in only one
	 * input1 [1,3,5]
	 * input2 [2,4,6]
	 * 
	 * output [1,2,3,4,5,6]
	 */
	public static void main(String[] args) {	
		
		String str = "this is / a new vlaue / adfad";
		System.out.println(str.split("/").length);
		/*
		int arr1[] = {1,3,4};
		int arr2[] = {1,3};
		System.out.println(merge(arr1,arr2));
		*/
	}
	
	public static List<Integer> merge(int[] arr1, int[] arr2) {
		List<Integer> result = new ArrayList<Integer>();
		
		int cA1 = 0, cA2 = 0;
		while(cA1 < arr1.length && cA2 < arr2.length) {
			if (arr1[cA1] <= arr2[cA2]) {
				if (result.size()>0 && result.get(result.size()-1) != arr1[cA1]) {
					result.add(arr1[cA1]);
				} else if (result.size()==0){
					result.add(arr1[cA1]);
				}
				cA1++;
			} else if (arr1[cA1] >= arr2[cA2]) {
				if (result.size()>0 && result.get(result.size()-1) != arr2[cA2]) {
					result.add(arr2[cA2]);
				} else if (result.size()==0){
					result.add(arr2[cA2]);
				}
				cA2++;
			}
		}
		
		if (cA1 < arr1.length) {
			for(int i=cA1; i<arr1.length; i++) {
				if (result.size()>0 && result.get(result.size()-1) != arr1[i]) {
					result.add(arr1[i]);
				} else if (result.size()==0){
					result.add(arr1[i]);
				}
			}
		}
		
		if (cA2 < arr2.length) {
			for(int i=cA2; i<arr2.length; i++) {
				if (result.size()>0 && result.get(result.size()-1) != arr2[i]) {
					result.add(arr2[i]);
				} else  if (result.size()==0){
					result.add(arr1[i]);
				}
			}
		}
		return result;
	}
}