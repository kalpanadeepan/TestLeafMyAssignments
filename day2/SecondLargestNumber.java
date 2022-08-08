package week1.day2;

import java.util.Arrays;

public class SecondLargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 22, 67, 98, 1, 34, 58, 99 };
		int len = a.length;
		Arrays.sort(a);
		System.out.println("The second largest Number is " + a[len - 2]);
	}

}
