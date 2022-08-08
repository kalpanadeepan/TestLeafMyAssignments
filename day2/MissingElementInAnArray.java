package week1.day2;

import java.util.Arrays;

public class MissingElementInAnArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Here is the input
		int[] arr = { 1, 2, 3, 4, 7, 6, 8 };

		// Sort the array

		// loop through the array (start i from arr[0] till the length of the array)

		// check if the iterator variable is not equal to the array values respectively

		// print the number

		// once printed break the iteration
		
		Arrays.sort(arr);

		int j = 1;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] != j) {
				System.out.println("The Missing Element In An Array is " + j);
				break;
			}
			j++;
		}

	}

}
