package week3.day2;

import java.util.HashSet;
import java.util.Set;

/*PrintUniqueCharacter
/*
 * Problem
 * 
 * a) Take your name as input
 * b) Print all unique characters only (any order)
 * 
 * Input:  babu
 * Output: a u 
 * 
 *//*
 * Psuedocode
 * 
 * a) Convert String to Character array
 * b) Create a new Set -> HashSet
 * c) Add each character to the Set and if it is already there, remove it
 * d) Finally, print the set
 * 
 */
public class PrintUniqueCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   String input="Kalpana";
   
   Set<Character> set=new HashSet<Character>();

   Set<Character> set1=new HashSet<Character>();
   char[] nameArray=input.toCharArray();
   for(int i=0;i<nameArray.length;i++)
   {
	   if(set.contains(nameArray[i]))
	   {   
		   set.add(nameArray[i]);
		   set1.remove(nameArray[i]);
	   }
	   else
	   {
		   set.add(nameArray[i]);
		   set1.add(nameArray[i]);
	   }
   }
   System.out.println("The all unique characters are "+set1);
   
   //System.out.println("The all unique characters are "+set);
   
	}

}
