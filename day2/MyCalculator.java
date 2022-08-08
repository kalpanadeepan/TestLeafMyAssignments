package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator c = new Calculator();
		System.out.println("The Sum is " + c.add(10, 20, 40));
		System.out.println("The Subtraction is " + c.sub(20, 10));
		System.out.println("The Multiplication is " + c.mul(22.2, 10.0));
		System.out.println("The Division is " + c.divide(55, 5));

	}

}
