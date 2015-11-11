package com.cei37.TreesGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

import com.cei37.TreesGraphs.adt.BSTree;
import com.cei37.TreesGraphs.adt.Node;

public class Q4_4 {

	/**
	 * Given a binary tree, design an algorithm which creates a linked list of all the
	 * nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked
	 * lists).
	 */
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		Random ran = new Random();
		while(set.size()<10) {
			set.add(ran.nextInt(100));
		}
		Integer arr[] = new Integer[set.size()]; 
		set.toArray(arr);
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		BSTree<Integer> bst = new BSTree<Integer>();
		bst.transformArrayToTree(arr);
		System.out.println("\nIs balanced: "+bst.isBalanced());
		System.out.println("Max Height: "+bst.getMaxheight());
		ArrayList<LinkedList<Integer>> list = bst.transformTreeToLinkedListEachDepth();
		for (LinkedList<Integer> l: list) {
			for (Integer i: l) {
				System.out.print(i + "-->");
			}
			System.out.println();
		}
		System.out.println("###########################");
		ArrayList<LinkedList<Node<Integer>>> list2 = bst.createLevelLinkedList();
		for (LinkedList<Node<Integer>> l: list2) {
			for (Node<Integer> i: l) {
				System.out.print(i.getValue() + "-->");
			}
			System.out.println();
		}
	}
}