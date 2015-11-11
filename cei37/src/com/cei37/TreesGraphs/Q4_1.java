package com.cei37.TreesGraphs;

import java.util.Random;

import com.cei37.TreesGraphs.adt.BSTree;

public class Q4_1 {

	/**
	 * Implement a function to check if a binary tree is balanced. For the purposes of
	 * this question, a balanced tree is defined to be a tree such that the heights of the
	 * two subtrees of any node never differ by more than one.
	 */
	public static void main(String[] args) {
		Random ran = new Random();
		BSTree<Integer> tree = new BSTree<Integer>();
		System.out.println("*********** generated *************");
		tree.insert(50);
		tree.insert(25);
		tree.insert(75);
		tree.insert(10);
		tree.insert(30);
		tree.insert(60);
		tree.insert(90);
		
		/*
		for (int i=0; i<5; i++) {
			Integer in = ran.nextInt(1000);
			System.out.println("\n"+in);
			tree.insert(in);
		}*/
		
		System.out.println("*********** preorder *************");
		tree.preorder();
		
		System.out.println("*********** inorder *************");
		tree.inorder();
		
		System.out.println("*********** postorder *************");
		tree.postorder();
		
		System.out.println("*********** level order *************");
		tree.levelOrder();
		
		System.out.println("*********** Search *************");
		System.out.println(tree.search(11));
		
		
		System.out.println("*********** isBalanced *************");
		System.out.println(tree.isBalanced());
		System.out.println(tree.isBalanced2());
	}
}