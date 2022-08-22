package week3.day2;


import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
	/*
	 * Problem 
	 * 
	 * There will be running number between 1 to 10
	 * One of the unique number will be missing
	 * Find the missing number
	 * 
	 * 
	 */
	
	/*
	 * Psuedocode
	 * 
	 * a) Remove the duplicates using Set
	 * b) Make sure the set is in the ascending order
	 * c) Iterate from the starting number and verify the next number is + 1
	 * d) If did not match, that is the number
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Integer> set=new HashSet<Integer>();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(5);
		set.add(4);
		set.add(6);
		set.add(8);
		set.add(8);
		set.add(9);
		set.add(9);
		set.add(8);
		set.add(10);
		
		System.out.println("The Set values are initialised "+set);
		
		for(int i=1;i<=10;i++)
		{
			if(!set.contains(i))
			{
				System.out.println("The Missing Number is "+i);
				break;
			}
		}

	}

}
