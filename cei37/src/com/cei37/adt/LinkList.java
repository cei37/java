package com.cei37.adt;

import java.util.HashMap;
import java.util.Map;


public class LinkList {
	public Link first;
	public Link last;
	int size;
	
	public LinkList() {
		first = null;
	}
	
	public int getSize() {
		return size;
	}
	
	public void insertFirst(int a) {
		Link newLink = new Link(a);
		newLink.next = first;
		first = newLink;
		if (last == null) {
			last = newLink;
		}
		size++;
	}
	
	public void insertLast(int a) {
		Link newLink = new Link(a);
		if (last==null) {
			last = newLink;
		} else {
			last.next = newLink;
			last = last.next;
		}
		if (first == null) {
			first = newLink;
		}
		size++;
	}
	
	public Link removeFirst() {
		Link tmp = first;
		first = first.next;
		size--;
		return tmp;
	}
	
	public Link find(int a) {
		Link current = first;
		while(current.data!=a) {
			if (current.next!=null) {
				current = current.next;
			} else {
				return null;
			}
		}
		return current;
	}
	
	public Link delete(int a) {
		Link current = first;
		Link previous = first;
		while (current.data != a) {
			if (current.next==null) {
				return null;
			} else {
				previous = current;
				current = current.next;
			}
		}
		
		if (current == first) {
			first = first.next;
		} else {
			previous.next = current.next;
		}
		size--;
		return current;
	}
	
	public void printAll() {
		Link current = first;
		while (current!=null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
	public void removeDuplicatesNoBufferAllowed() {
		/*
		 * This code runs in 0(1) space, but 0(N2) time
		 */
		Link current = first;
		while(current!=null) {
			Link runner = current;
			while(runner.next!=null) {
				if (current.data == runner.next.data) {
					runner.next = runner.next.next;
					size--;
				}
				runner = runner.next;
			}
			current = current.next;
		}
		
	}
	
	public void removeDuplicates() {
		/*
		 * takes 0(N) time
		 */
		Map<Integer,Boolean> map = new HashMap<Integer,Boolean>();
 		Link current = first;
 		Link previous = null;
		while(current!=null) {
			if (map.containsKey(current.data)) {
				previous.next = current.next;
				size--;
			} else {
				map.put(current.data, true);
				previous = current;
			}
			current = current.next;
		}
	}
	
	public int findTheKt(Link link, int pos) {
		/*
		Link current = first;
		int con = 1;
		while(current!=null && con<pos) {
			current = current.next;
			con++;
		}
		return current; */
		
		if (link==null) {
			return 0;
		}
		
		int i = findTheKt(link.next, pos) + 1;
		if (i==pos) {
			System.out.println(link.data);
		}
		return i;
	}
	
	public void splitList(int value, LinkList left, LinkList right) {
		Link current = first;        
		while(current!=null) {
			if (current.data<value) {
				left.insertFirst(current.data);
			} else {
				right.insertFirst(current.data);
			}
			current = current.next;
		}
	}
	
	public LinkList invertList() {
		LinkList listTem = new LinkList();
		Link current = first;
		while(current!=null) {
			listTem.insertFirst(current.data);
			current = current.next;
		}
		return listTem;
	}
	
	public String concatenateValues() {
		StringBuffer st = new StringBuffer();
		Link current = first;
		while(current!=null) {
			st.append(current.data);
			current = current.next;
		}
		return st.toString();
	}
	
	public boolean isPalindrome() {
		Link current = first;
		LinkList list = invertList();
		Link current2 = list.first;
		int i=0;
		while(current!=null && i < size/2) {
			if (current.data != current2.data) {
				return false;
			}
			current = current.next;
			current2 = current2.next;
		}
		return true;
	}
	
	public boolean isPalindromeUsingStack() {
		Stack stack = new Stack();
		Link slow = first;
		Link fast = first;
		boolean middle = true;
		while(fast!=null && fast.next!=null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		stack.printAll();
		while(slow!=null) {
			if (slow.data != stack.peek().data) {
				if (middle && slow.next.data == stack.peek().data) {
					slow = slow.next;
					middle = false;					
				} else {
					return false;
				}
			}
			stack.pop();
			slow = slow.next;
		}
		return true;
	}
	
	public boolean isPalindromeUsingRecursion() {

		return true;
	}
	
	public void addNewHead(Link link) {
		first = link;
	}
	
	public boolean hasLoop() {
		Link fast = first;
		Link slow = first;
		
		while(fast != null && fast.next != null && slow!=null && slow.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public boolean removeLoop() {
		Link fast = first;
		Link slow = first;

		while(fast != null && fast.next != null && slow!=null && slow.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				fast = first;
				while(fast.next!=slow.next) {
					fast = fast.next;
					slow = slow.next;
				}
				slow.next = null;
				return true;
			}
		}
		return false;
	}
	
	public void createLoop(int pos) {
		Link current = first;
		int i = 1;
		while(i<pos) {
			current = current.next;
			i++;
		}
		last.next = current;
	}
}
