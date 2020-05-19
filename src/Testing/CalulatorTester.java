package Testing;

import big_numbers.Calculator;
public class CalulatorTester {

	public static void main(String[] args) {
		Calculator Karren = new Calculator();
		String re = Karren.calculate("1","-","2");
		System.out.println(re);

	}

}
