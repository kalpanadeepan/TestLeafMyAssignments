package week1.day1;
//Problem statement: Check if the number is positive or negative

/*Pseudocode
 * : ---------- 
 * 1. Initialize a number, say, int number= 35; 
 * 
 * 2. If a number is positive, print "The number is positive" 
 * 
 * If a number is negative, print "The number is negative" 
 * 
 * If it nether negative nor positive, print as
 * 
 * "The number is neither positive nor negative"
 */

public class CheckIfTheNumberIsPositiveOrNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number = 35;
		if (number > 0) {
			System.out.println("The given number" + number + " is Positive");
		} else if (number < 0)

		{
			System.out.println("The given number" + number + " is Negative");
		} else {
			System.out.println("The number"+number+" is neither positive nor negative");
		}

	}

}
