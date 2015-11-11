package com.cei37.binaryTree;

import java.util.Map;

public class TestTree {
	public static void main(String str[]) {
		/*
		Node root = new Node(100);
		Node left1 = new Node(50);
		Node left2 = new Node(60);
		Node left3 = new Node(30);
		Node left4 = new Node(21);
		root.left = left1;
		left1.right = left2;
		left1.left = left3;
		left3.left = left4;
		
		Node right1 = new Node(150);
		Node right2 = new Node(160);
		Node right3 = new Node(130);
		Node right4 = new Node(121);
		root.right = right1;
		right1.right = right2;
		right1.left = right3;
		right3.left = right4;
		*/
		
		Node root = new Node(100);
		root.insert(100);
		root.insert(50);
		root.insert(60);
		root.insert(30);
		root.insert(21);
		root.insert(150);
		root.insert(160);
		root.insert(130);
		root.insert(121);
		
		Tree tree = new Tree();
		System.out.println("Preorder");
		tree.preOrder(root);
		
		System.out.println("Inorder");
		tree.inOrder(root);
		
		System.out.println("PostOrder");
		tree.postOrder(root);
		
	}
}


class Node {
	Node left;
	int data;
	Node right;
	public Node(int data) {
		this.data = data;
		left = right = null;
	}
	
	public void insert(int data) {
		if (data < this.data) {
			if (left == null)
				left = new Node(data);
			else
				left.insert(data);
		} else if (data > this.data) {
			if (right == null)
				right = new Node(data);
			else
				right.insert(data);
		}
	}
}


class Tree {
	public void preOrder(Node node) {
		if (node!=null) {
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void inOrder(Node node) {
		if (node!=null) {
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	
	public void postOrder(Node node) {
		if (node!=null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
	}
}