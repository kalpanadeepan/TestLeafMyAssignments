package week1.day2;

public class Fibbinocci {
//	Print Fibbinocci series for first 11 numbers
//
//	0 1 1 2 3 5 8 13 21 35 56 
//
//	Goal: To understand the arthimetic operation and loop
//
//	a) Create a class by name: Fibbinocci
//	b) Create a main method using shortcut
//	c) Write a logic to print fibbinocci from 0 to 56

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int firstNum = 0, secNum = 1, sum = 0;
		System.out.print(firstNum + " ");
		int c = 1;
		firstNum = secNum;
		secNum = sum;
		sum = 0;
		while (c < 11) {

			sum = firstNum + secNum;
			System.out.print(sum + " ");
			firstNum = secNum;
			secNum = sum;
			c++;
		}

	}

}
