package com.cei37.search;

public class BinarySearch {
	public static void main(String[] arg) {
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int key = 7; 
		int pos = BinarySearch.search(arr, key);
		System.out.println(pos);
	}
	
	public static int search(int[] arr, int key) {
		int l = 0, r = arr.length -1;
		while (l<r) {
			int mid = l + (r - l) / 2; 
			if (key > arr[mid]) {
				l = mid + 1;
			} else if (key < arr[mid]) {
				r = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}