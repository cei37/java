package com.cei37.TreesGraphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.cei37.TreesGraphs.adt.BSTree;

public class Q4_5 {

	/**
	 * Implement a function to check if a binary tree is a binary search tree.
	 */
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Random ran = new Random();
		BSTree<Integer> bst = new BSTree<Integer>();
		while(set.size()<100) {
			set.add(ran.nextInt(1000));
		}
		Integer arr[] = new Integer[set.size()]; 
		set.toArray(arr);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		bst.transformArrayToTree(arr);
		
		System.out.println(bst.isBinarySearchTree());
	}
}