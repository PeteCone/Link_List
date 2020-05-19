package Testing;

import data_structures.LinkedList;
import data_structures.ListI;



public class LinkListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListI<Integer> ll = new LinkedList<Integer>();
		for(int i = 0; i < 10; i++) {
			System.out.println("Adding " +i);
			ll.addLast(i);
		}
		System.out.println();
		for(int i = 0; i<10; i++) {
			System.out.println("Remove " + ll.removeFirst());
		}
	}

}
