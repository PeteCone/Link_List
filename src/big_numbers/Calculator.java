package big_numbers;

/**
 *  @author Peter Conant
 * This program will take in three strings (two numbers, one a math symbol) 
 * and calculate the desired
 * result. It can multiple, divide, add, and subtract
 */


public class Calculator {
	BigNumber bigNum1 = new BigNumber();
	BigNumber bigNum2 = new BigNumber();
	BigNumber result = new BigNumber();

	public Calculator() {

	}

	public String calculate(String number1, String operation, String number2) {

		
		
		
		
		bigNum1.stringToBigNumber(number1);
		bigNum2.stringToBigNumber(number2);


		if(operation.compareTo("+")==0) {
			addition();
		}
		else if(operation == "-") {
			subtraction();
		}
		else if(operation == "*") {
			mulitplication();
		}
		else if(operation == "/") {
			division();
		}


		while(result.peekFirstDigit()==0) {
			result.getFirstDigit();
		}

		return result.toString();
	}
	//Simulates long division
	private String division() {


		return null;
	}
	
	//Simulates long division
	private String subtraction() {
		boolean carry = false;
		int biggerNumLength = 0;

		if(bigNum1.length() > bigNum2.length())
			biggerNumLength = bigNum1.length();
		else
			biggerNumLength = bigNum2.length();

		for(int i = 0; i < biggerNumLength; i++) {

			int tmpNum = 0;

			tmpNum = bigNum1.getLastDigit() - bigNum2.getLastDigit();
			
			if(carry)
				tmpNum--;
			
			if(tmpNum < 0) {
				carry = true;
				tmpNum = tmpNum + 10;
			}

			result.addFirstDigit(tmpNum);

		}
		return result.toString();


	}
	//simulates long multiplication
	private String mulitplication() {
		
		return null;

	}
	//Simulates addition with large numbers
	private String addition() {
		boolean carry = false;
		int biggerNumLength = 0;

		if(bigNum1.length() > bigNum2.length())
			biggerNumLength = bigNum1.length();
		else
			biggerNumLength = bigNum2.length();

		for(int i = 0; i < biggerNumLength; i++) {
			int tmpNum = 0;
			tmpNum = bigNum1.getLastDigit() + bigNum2.getLastDigit();
			if(carry)
				tmpNum++;
			carry=false;

			if(tmpNum >= 10) {
				carry = true;
				tmpNum = tmpNum-10;
			}
			result.addFirstDigit(tmpNum);

		}
		return result.toString();
	}

}
