package com.cei37.TreesGraphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.cei37.TreesGraphs.adt.BSTree;

public class Q4_3 {

	/**
	 * Given a sorted (increasing order) array with unique integer elements, write an
	 * algorithm to create a binary search tree with minimal height.
	 */
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Random ran = new Random();
		while(set.size()<30) {
			set.add(ran.nextInt(100));
		}
		Integer arr[] = new Integer[set.size()]; 
		set.toArray(arr);
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		BSTree<Integer> bst = new BSTree<Integer>();
		bst.transformArrayToTree(arr);
		System.out.println("Is balanced: "+bst.isBalanced());
	}
}