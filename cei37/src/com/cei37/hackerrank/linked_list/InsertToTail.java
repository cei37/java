package com.cei37.hackerrank.linked_list;

public class InsertToTail {
	public static void main(String[] arg) {
		Node t1 = new Node();
		t1.data = 4;
		Node t2 = new Node();
		t2.data = 2;
		Node t3 = new Node();
		t3.data = 3;
		Node t4 = new Node();
		t4.data = 4;
		Node t5 = new Node();
		t5.data = 1;
		t1.next = t2;
		t1.next.next = t3;
		t1.next.next.next = t4;
		t1.next.next.next.next = t5;
		//Insert(t1,10);
		//System.out.println("Original");
		//printList(t1);
		//System.out.println("Result");
		//printList(InsertNth(t1,15,6));
		
		/*
		System.out.println("Original list");
		printList(t1);
		reverseRecursion(t1);
		printList(h);
		*/
		
		System.out.println("Original list");
		printList(t1);
		printList(reverse(t1));
		
	}
	
	static Node reverse(Node head) {
		Node newList = new Node();
		if (head!=null) {
			boolean first = true;
			while(head!=null) {
				if (first){
					first=false;
					newList.data = head.data;
				} else {
					Node temx = new Node();
					temx.data = head.data;
					temx.next = newList;
					newList = temx; 
				}
				head = head.next;
			}
		}
		return newList;
	}
	
	
	
	
	static Node n;
	static Node h;
	static int i=0;
	static void reverseRecursion(Node head) {
		if (head!=null) {
	        i++;
	        reverseRecursion(head.next);
	        i--;
			if (n==null) {
	        	n = head;
	        	h = head;
	        } else {
	        	n.next = head;
	        	n = n.next;
	        }
	    }
		if (i==0)
			n.next = null;
	}
	
	static Node Insert(Node head, int data) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		Node node = new Node();
		node.data = data;
		if (head == null) {
			head = node;
			return node;
		} else {
			Node tem = head;
			while (tem.next != null) {
				System.out.println(tem.data);
				tem = tem.next;
			}
			tem.next = node;
			printList(head);
			return head;
		}
	}
	
	static void printList(Node head) {
		System.out.println("Printing list");
		Node tem = head;
		while(tem!=null) {
			System.out.println(tem.data);
			tem = tem.next;
		}
	}
	
	static Node InsertNth(Node head, int data, int position) {
	    Node node = new Node();
	    node.data = data;
	    if (head==null) {
	        head = node;
	    } else if (position == 0) {
	        node.next = head;
	        head = node;
	    } else {
	        Node tem = head;
	        int pos=0;
	        while(tem!=null && pos < position) {
	            pos++;
	            if (pos == position) {
	            	Node rest = tem.next;
	                tem.next=node;
	                node.next = rest; 
	                break;
	            }
	            tem=tem.next;
	        }
	    }
	    return head;
	}
}
