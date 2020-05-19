package Testing;

import big_numbers.BigNumber;


public class BigNumTest {
	public static void main(String args[]) {
		BigNumber num = new BigNumber();
		String dick = "10";
		
		num.stringToBigNumber(dick);
		num.setNegative(true);
		
		System.out.println(num.toString());
		System.out.println(num.length());
		System.out.println(num.getNegative());
		num.addFirstDigit(1);
		num.addLastDigit(4);
		num.setNegative(false);
		System.out.println(num.toString());
		System.out.println(num.peekFirstDigit());
		System.out.println(num.peekLastDigit());
		
		
		
	}

}
