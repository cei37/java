package com.cei37.TreesGraphs.adt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTree<Type extends Comparable<Type>> {
	private Node<Type> node;
	
	public void insert(Type value) {
		if (this.node == null) {
			this.node = new Node<Type>();
			this.node.setValue(value);
			System.out.println("first ");
		} else {
			insert(this.node, value);
		}
	}
	
	private void insert(Node<Type> node, Type value) {
		if (node == null) {
			node = new Node<Type>();
			node.setValue(value);
			System.out.print("equals");
		} else if (node.compareTo(value)<0) {
			if (node.getRight()!=null) {
				System.out.print("right-->");
				insert(node.getRight(), value);
			} else {
				Node<Type> tmp = new Node<Type>();
				tmp.setValue(value);
				node.setRight(tmp);
				System.out.println("right");
			}
		} else if (node.compareTo(value)>0) {
			if (node.getLeft()!=null) {
				System.out.print("left-->");
				insert(node.getLeft(), value);
			} else {
				Node<Type> tmp = new Node<Type>();
				tmp.setValue(value);
				node.setLeft(tmp);
				System.out.println("left");
			}
		} else {
			node.setValue(value);
		}
	}
	
	public void preorder() {
		preorder(this.node);
		preorder2(this.node);
	}
	
	private void preorder2(Node<Type> node) {
		System.out.println("Preorder without recursion");
		if (node == null) {
			return;
		}
		Stack<Node<Type>> stack = new Stack<Node<Type>>();
		stack.push(node);
		while(!stack.isEmpty()) {
			Node<Type> tmp = stack.pop();
			System.out.println(tmp.getValue());
			if (tmp.getRight()!=null) {
				stack.push(tmp.getRight());
			}
			if (tmp.getLeft()!=null) {
				stack.push(tmp.getLeft());
			}
		}
		
	}
	
	private void preorder(Node<Type> node) {
		if (node == null) {
			return;
		}
		System.out.println(node.getValue());
		preorder(node.getLeft());
		preorder((node.getRight()));
	}
	
	public void inorder() {
		inorder(this.node);
		inorder2(this.node);
	}
	
	private void inorder2(Node<Type> node) {
		System.out.println("in-order without recursion");
		if (node == null) {
			return;
		}
		Stack<Node<Type>> stack = new Stack<Node<Type>>();
		Node<Type> current = node;
		while(current!=null || !stack.isEmpty()) {
			if(current!=null) {
				stack.push(current);
				current = current.getLeft();
			} else if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.println(current.getValue());
				current = current.getRight();
			}
		}
	}
	
	private void inorder(Node<Type> node) {
		if (node == null) {
			return;
		}
		inorder(node.getLeft());
		System.out.println(node.getValue());
		inorder((node.getRight()));
	}
	
	public void postorder() {
		postorder(this.node);
		postorder2(this.node);
	}
	
	private void postorder2(Node<Type> head) {
		System.out.println("postorder without recursion");
		if (node == null) {
			return;
		}
		Stack<Node<Type>> stack = new Stack<Node<Type>>();
		stack.push(head);

		while (!stack.isEmpty()) {
			Node<Type> next = stack.peek();
			if (next.right == head || next.left == head || (next.left == null && next.right == null)) {
				stack.pop();
				System.out.println(next.value);
				head = next;
			} else {
				if (next.right != null) {
					stack.push(next.right);
				}
				if (next.left != null) {
					stack.push(next.left);
				}
			}
		}
	}
	
	private void postorder(Node<Type> node) {
		if (node == null) {
			return;
		}
		postorder(node.getLeft());
		postorder((node.getRight()));
		System.out.println(node.getValue());
	}
	
	public boolean isBalanced() {
		if (this.node == null) {
			return true;
		} else {
			int left = maxHeight(this.node.getLeft());
			int right = maxHeight(this.node.getRight());
			if (Math.abs(left-right)<=1) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public int getMaxheight() {
		if (this.node == null) {
			return 0;
		} else {
			int left = maxHeight(this.node.getLeft())+1;
			int right = maxHeight(this.node.getRight())+1;
			if (left>right) {
				return left;
			} else {
				return right;
			}
		}
	}
	
	private int maxHeight(Node<Type> node) {
		if (node == null) {
			return 0;
		}
		int left_height = maxHeight(node.getLeft());
		int right_height = maxHeight(node.getRight());
		return (left_height > right_height) ? left_height + 1 : right_height + 1;
	}
	
	public boolean isBalanced2() {
		//seems like it is not working properly
		if (checkHeight(node) == -1) {
			return false;
		} else {
			return true;
		}
	}
	
	private int checkHeight(Node<Type> node) {
		if (node == null) {
			return 1;
		}
		int left = checkHeight(node.left);
		if (left == -1) {
			return -1;
		}
		
		int right = checkHeight(node.right);
		if (right == -1) {
			return -1;
		}
		
		int diff = right - left;
		if (Math.abs(diff)>1) {
			return -1; //not balanced
		} else {
			return Math.max(right, left) + 1;
		}
	}
	
	public void transformArrayToTree(Type[] arr) {
		transformArrayToTree(arr,0,arr.length-1);
	}
	
	private void transformArrayToTree(Type[] arr, int li, int ls) {
		if (li>ls) {
			return;
		}
		int mid = li + (ls-li)/2;
		insert(arr[mid]);
		transformArrayToTree(arr,li,mid-1);
		transformArrayToTree(arr,mid+1,ls);
	}
	
	public ArrayList<LinkedList<Type>> transformTreeToLinkedListEachDepth() {
		/**
		 * Given a binary tree, design an algorithm which creates a linked list of all the
		 * nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked
		 * lists).
		 */
		
		ArrayList<LinkedList<Type>> list = new ArrayList<LinkedList<Type>>(); //here I will store the linked list, it should be equals to D
		LinkedList<Node<Type>> queue =  new LinkedList<Node<Type>>(); // this is a queue used to traverse the TREE using Breadth First Search
		LinkedList<Node<Type>> tmpQueue =  new LinkedList<Node<Type>>(); // temporal queue used to store the child of each visited node
		LinkedList<Type> linkedList = new LinkedList<Type>(); // it will represent each linkedlist for each level in the tree
		queue.add(this.node);
		while(!queue.isEmpty()) {
			Node<Type> tmpNode = queue.removeFirst();
			if (tmpNode.getLeft()!=null) {
				tmpQueue.add(tmpNode.getLeft());
			}
			if (tmpNode.getRight()!=null) {
				tmpQueue.add(tmpNode.getRight());
			}
			linkedList.add(tmpNode.value);
			if (queue.isEmpty()) {
				list.add(linkedList);
				linkedList = new LinkedList<Type>();
				while(!tmpQueue.isEmpty()) {
					queue.add(tmpQueue.removeLast());
				}
			}
		}
		return list;
	}
	
	private void createLevelLinkedList(Node<Type> root, ArrayList<LinkedList<Node<Type>>> lists, int level) {
		if (root == null)
			return; // base case
		LinkedList<Node<Type>> list = null;
		if (lists.size() == level) {
			list = new LinkedList<Node<Type>>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}

	public ArrayList<LinkedList<Node<Type>>> createLevelLinkedList() {
		/**
		 * Given a binary tree, design an algorithm which creates a linked list of all the
		 * nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked
		 * lists).
		 */
		ArrayList<LinkedList<Node<Type>>> lists = new ArrayList<LinkedList<Node<Type>>>();
		createLevelLinkedList(this.node, lists, 0);
		return lists;
	}
	
	public boolean isBinarySearchTree() {
		/**
		 * Implement a function to check if a binary tree is a binary search tree.
		 */
		return isBinary(this.node, (Type)new Integer(Integer.MIN_VALUE), (Type)new Integer(Integer.MAX_VALUE));
	}
	
	private boolean isBinary(Node<Type> node, Type min, Type max) {
		if (node == null) {
			return true;
		}
		if (min.compareTo(max) != 0) {
			if (node.compareTo(min)>=0 || node.compareTo(max)<=0) {
				return false;
			}
		}
		if (isBinary(node.getLeft(), min, node.getValue()) || isBinary(node.getRight(), node.getValue(), max)) {
			return false;
		}
		return true;
	}
	
	public void levelOrder() {
		System.out.println("This is a traversal lever-order.");
		if (node == null) {
			return;
		}
		
		Queue<Node<Type>> queue = new LinkedList<Node<Type>>();
		queue.add(node);
		while(!queue.isEmpty()) {
			Node<Type> tmpNode = queue.poll();
			System.out.println(tmpNode.getValue());
			if (tmpNode.getLeft()!=null) {
				queue.add(tmpNode.getLeft());
			}
			if (tmpNode.getRight()!=null) {
				queue.add(tmpNode.getRight());
			}
		}
	}
	
	public Node<Type> search(Type value) {
		if (node == null) {
			return null;
		} else {
			Node<Type> current = node;
			while(current!=null) {
				if (current.getValue().compareTo(value)==0) {
					return current;
				} else {
					if (current.getValue().compareTo(value)<0) {
						current = current.getLeft();
					} else {
						current = current.getRight();
					}
				}
			}
		}
		return null;
	}
}