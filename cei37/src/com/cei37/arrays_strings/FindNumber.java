package com.cei37.arrays_strings;

public class FindNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,2,2,2,2,3,3,3,3,3,5,5,6,6,6,6,6,7,7,7,7,7,7,7,7,7,7,7,8,8,8,9};
		System.out.println(findOccurrence(5,arr));
	}
	
	public static int findOccurrence(int number, int[] arr) {
		int pos = findNumber(number,arr);
		if (pos>0) {
			int occurrence = 1, leftCounter = pos, rightCounter = pos;
			boolean goToLeft = true, goToRight = true;
			
			while (goToLeft || goToRight) {
				if (goToLeft && leftCounter-1>=0 && arr[leftCounter-1] == number) {
					leftCounter--;
					occurrence++;
				} else {
					goToLeft = false;
				}
				
				if (goToRight && rightCounter+1<arr.length && arr[rightCounter+1] == number) {
					rightCounter++;
					occurrence++;
				} else {
					goToRight = false;
				}
			}
			
			return occurrence;
		} else {
			return 0;
		}
	}
	
	public static int findNumber(int number, int[] arr) {
		int left = 0, right = arr.length -1;
		int mid = 0;
		while(right>=left) {
			mid = left + (right - left) / 2;
			if (arr[mid] > number) {
				//heading to left;
				right = mid-1;
			} else if (arr[mid]<number){
				//heading to right;
				left = mid + 1;
			} else {
				//found the correct value;
				return mid;
			}
		}
		return -1;
	}
}