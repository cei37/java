package com.cei37.linkedListImplementation;

public class LinkedList<Type extends Comparable<Type>> {
	private Node<Type> head;
	private Node<Type> tail;
	
	public void addFirst(Type value) {
		if (isEmpty()) {
			head = new Node<Type>(value);
			tail = head;
		} else {
			Node<Type> tmp = new Node<Type>(value);
			tmp.setNext(head);
			head = tmp;
		}
	}
	
	public Node<Type> getHead() {
		return head;
	}
	
	public Node<Type> getTail() {
		return tail;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public void addLast(Type value) {
		if (isEmpty()) {
			tail = new Node<Type>(value);
			head = tail;
		} else {
			Node<Type> newTail = new Node<Type>(value);
			tail.setNext(newTail);
			tail = newTail;
		}
	}
	
	public void addLast(Node<Type> node) {
		if (isEmpty()) {
			tail = node;
			head = tail;
		} else {
			Node<Type> newTail = node;
			tail.setNext(newTail);
			while(tail.getNext()!=null) {
				tail = tail.getNext();	
			}
		}
	}
	
	
	public void printAll() {
		Node<Type> next = head;
		while(next!=null) {
			System.out.print(next.getValue()+" --> ");
			next = next.getNext();
		}
	}
	
	public boolean updateNode(Type value, Type newValue) {
		Node<Type> next = head;
		boolean flag = false;
		while(next!=null) {
			if (next.getValue().compareTo(value)==0) {
				next.setValue(newValue);
				flag = true;
			}
			next = next.getNext();
		}
		return flag;
	}
	
	public boolean makeCircularLink(Type value) {
		Node<Type> next = head;
		Node<Type> link = null;
		while(next!=null) {
			if (next.getValue().compareTo(value)==0) {
				link = next;
			}
			if (next.getNext()==null) {
				next.setNext(link);
				return true;
			}
			next = next.getNext();
		}
		return false;
	}
	
	public boolean hasLoop() {
		if (head==null || head.getNext()==null) {
			return false;
		}
		Node<Type> slow = head;
		Node<Type> fast = head.getNext();
		
		while(slow!=null) {
			if (slow == fast) {
				return true;
			}
			slow = slow.getNext();
			if (fast!=null && fast.getNext()!=null) {
				fast = fast.getNext().getNext();;
			} else {
				return false;
			}
		}
		return false;
	}
	
	public boolean removeFirst() {
		if (head == null) {
			return false; 
		} else {
			head = head.getNext();
			return true;
		}
	}
	
	public boolean removeLast() {
		if (isEmpty()) {
			return false; 
		} else {
			Node<Type> current = getHead();
			while(current!=null && current.getNext()!=null) {
				if (current.getNext()==getTail()) {
					current.setNext(null);
					tail = current;
					return true;
				}
				current = current.getNext();
			}
			return false;
		}
	}
	
	/*
	 * This method will merge the current list with an additional
	 * those list should be ordered, current list and list2 won't
	 * be altered
	 */
	public LinkedList<Type> joinLists(LinkedList<Type> list2) throws Exception{
		if (this.hasLoop() || list2.hasLoop()) {
            throw new Exception("There is a loop in one of the list");
        }        

        if (this.isEmpty() && !list2.isEmpty()) {
            return list2;
        } else if (list2.isEmpty() && !list2.isEmpty()) {
            return this;
        }
       
        LinkedList<Type> result = new LinkedList<Type>();
        Node<Type> current1 = this.getHead();
        Node<Type> current2 = list2.getHead();
        
        while(current1!=null && current2!=null) {
            if (current1.getValue().compareTo(current2.getValue())<0) {
                result.addLast(current1.getValue());
                current1 = current1.getNext();
            } else {
                result.addLast(current2.getValue());
                current2 = current2.getNext();
            }
        }
        /*
        if (current1 == null && current2!=null) {
        	result.addLast(current2);
        }
        
        if (current2 == null && current1!=null) {
            result.addLast(current1);
        } */
        
        
        while (current1 == null && current2!=null) {
            result.addLast(current2.getValue());
            current2 = current2.getNext();
        }
        
        while (current2 == null && current1!=null) {
            result.addLast(current1.getValue());
            current1 = current1.getNext();
        } 
        
        return result;
	}
	
	public void reverse() {
		if (isEmpty()) {
			return;
		}
		
		if (head == tail) {
			return;
		}
		
		Node<Type> tem = head;
		head = tail;
		head.setNext(tem.getNext());
		tail = tem;
		
	}
}


class Node<T> {
	private Node<T> next;
	private T value;
	
	protected T getValue() {
		return value;
	}

	protected void setValue(T value) {
		this.value = value;
	}

	protected Node(T value) {
		next = null;
		this.value = value;
	}

	protected Node<T> getNext() {
		return next;
	}

	protected void setNext(Node<T> next) {
		this.next = next;
	}
}