package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Peter Conant
 * This Program is designed to create a Linked List to Store and retrieve data. 
 * It can add data, remove data, iterate through the list, and search for an 
 * item in the list. 
 *
 */


public class LinkedList<E> implements ListI<E> {

	private Node<E> head;
	private Node<E> tail;
	private int currentSize;

	//Constructor
	public LinkedList() {
		head = null;
		tail = null;
		currentSize = 0;


	}

	class Node<E> { 
		E data;
		Node<E> next;

		public Node(E obj) {
			data = obj;
			next = null;
		}
	}
	
	//Adds a new node to the beginning of the list and increase the currentSize.
	@Override
	public void addFirst(E data) {
		Node<E> newNode = new Node<E>(data); 
		newNode.next = head;
		if(tail == null)
			tail = newNode;
		head = newNode;
		currentSize++;

	}

	//Adds a new node to tend end of the list and increases currentSize.
	@Override
	public void addLast(E data) {
		Node<E> newNode = new Node<E>(data);
		if(head==null) {
			addFirst(data);
			return;
		}
		Node<E> tmp = head;
		tail.next=newNode;
		tail = newNode;
		currentSize++;
	}

	//Removes the fist node of the list and decrements currentSize.
	@Override
	public E removeFirst() {
		if(head == null)
			return null;
		E tmp = head.data;
		if(head == tail)
			head = tail = null;
		else
			head = head.next;
		currentSize--;
		return tmp;

	}
	
	//Removes the fist node of the list and decrements currentSize.
	@Override
	public E removeLast() {
		if(head==null)
			return null;
		if(head==tail)
			return removeFirst();

		Node<E> current = head;
		Node<E> previous = null;
		while(current.next != null) {
			previous = current;
			current = current.next;
		}

		previous.next = null;
		tail= previous;
		currentSize--;

		return current.data;
	}
	
	//Removes a specified object from the list.
	public E remove(E obj) {
		Node<E> current = head, previous = null;
		while(current!= null) {
			if(((Comparable<E>)current.data).compareTo(obj) == 0){
				if(current == head)
					return removeFirst();
				if(current == tail)
					return removeLast();
				currentSize--;
				previous.next = current.next;
				return current.data;
			}
			previous = current;
			current = current.next;
		}
		return null;

	}

	//Returns the data of the first node.
	@Override
	public E peekFirst() {
		if(head == null) {
			return null;
		}
		return head.data;
	}

	//Returns the data of the last node in the list.
	@Override
	public E peekLast() {
		if(head == null) {
			return null;
		}
		return tail.data;
	}

	//Clears the list and makes the currentSize zero.
	@Override
	public void makeEmpty() {
		head=tail=null;
		currentSize = 0;

	}

	//Returns true if there is no.
	@Override
	public boolean isEmpty() {
		return(head == null);
	}

	//Will always return false because linked lists will only be full when out of memory.
	@Override
	public boolean isFull() {
		return false;
	}

	//Returns the side of the list.
	@Override
	public int size() {
		return currentSize;
	}

	//Returns true if a specified object is in the list.
	@Override
	public boolean contains(E obj) {
		Node<E> tmp = head;
		while(tmp.data != null) {
			if(((Comparable<E>)tmp.data).compareTo(obj)==0)
				return true;
			tmp=tmp.next;
		}

		return false;
	}

	//Creates a new iterator to go through the list.
	@Override
	public Iterator<E> iterator() {
		return new IteratorHelper();
	}

	class IteratorHelper implements Iterator<E> {
		Node<E> index;

		//Constructor
		public IteratorHelper() {
			index = head;
		}

		//Checks if the next element exists.
		@Override
		public boolean hasNext() {
			return index != null;
		}

		//returns the next element in the list.
		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E tmp=index.data;
			index = index.next;
			return tmp;
		}
	}

}
