package week1.day2;

public class IsPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;
		int j = 2, c = 0;

		for (int i = 2; i <= N; i++) { // Iterate through all numbers from 2 to n-1 (input)
			c = 0;

			for (j = 2; j < i; j++) { //for every number check if it divides n (input). 

				if (i % j == 0) {//If we find any number that divides, print prime.
					c++;
					break;
				}
			}
			if (c == 0) {
				System.out.println(i + " a prime ");

			} else {
				System.out.println(i + " not a prime ");
			}

		}

	}
}
