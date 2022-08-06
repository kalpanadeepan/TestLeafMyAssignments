package week1.day1;
/*
*Problem statement: Convert a negative number to positive number
 * Pseudocode: 
 * 
 * 1. Initialize an integer with a negative number like,
 * int number = -40;
 * 
 * 2. Check if the number is a negative number 
 * 
 * 
 * Hint : any number that is lesser than zero is a negative number 
 * 
 * 
 * 3. If so, convert the number to a positive number
 * 
 * 
 * 4. Print the converted positive number
 */

public class ConvertANegativeNumberToPositiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = -40;
		if (number < 0) {
			number = -number;
		}
		System.out.println("The Result is " + number);

	}

}
