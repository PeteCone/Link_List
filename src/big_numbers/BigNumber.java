package big_numbers;

import data_structures.LinkedList;
import data_structures.ListI;

/**
 * @author Peter Conant
 * This code will create a new List that can contain large numbers and will add/remove to the 
 * number, peek, keeps track of negatives and convert the number to a string. Use peek/getFirst
 * to look at the most significant digit.
 * 
 */


public class BigNumber {
	ListI<Integer> bigNum = new LinkedList<Integer>();
	boolean negative;
	
	public BigNumber(){
	}

	//remove and return the first digit
	public int getFirstDigit() {
		if(bigNum.isEmpty())
			return 0;
		return bigNum.removeFirst();	
	}
	
	//remove and return the last digit
	public int getLastDigit() {
		if(bigNum.isEmpty())
			return 0;
		return bigNum.removeLast();
	}
	
	//add a new digit to the the most significant point 
	public void addFirstDigit(int i) {
		bigNum.addFirst(i);
	}
	
	//add a new digit to the least significant point
	public void addLastDigit(int i) {
		bigNum.addLast(i);
	}
	
	//set if the number is negative or positive
	public void setNegative(boolean b) {
		negative = b;
	}
	
	//return true if the number negative
	public boolean getNegative() {
		return negative;
	}
	
	//returns the size of the number
	public int length() {
		return bigNum.size();
	}
	
	//Converts a string into a number on the list. String must contain characters "0"-"9"
	public void stringToBigNumber(String s) {
		for(int i = 0; i < s.length(); i++) {
			bigNum.addLast(Character.getNumericValue(s.charAt(i)));
		}
	}
	
	//Turns number list back into string
	public String toString() {
		String num = "";
		if(getNegative())
			num="-";
		for(Integer i : bigNum) {
			num = num + i + "";
		}
			
		return num;
	}
	
	//returns the most significant digit without removing it
	public int peekFirstDigit() {
		if(bigNum.isEmpty())
			return 0;
		return bigNum.peekFirst();
	}
	
	//returns the least significant digit without removing it
	public int peekLastDigit() {
		if(bigNum.isEmpty())
			return 0;
		return bigNum.peekLast();
	}
}
