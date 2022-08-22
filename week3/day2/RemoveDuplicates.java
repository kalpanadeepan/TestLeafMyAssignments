package week3.day2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declare a String as PayPal India
		String in="PayPal India";

//		Convert it into a character array
		in=in.replaceAll("\\s", "");
		
		char cArray[]=in.toCharArray();

//		Declare a Set as charSet for Character
		
		Set<Character> charSet=new HashSet<Character>();
           
//		Declare a Set as dupCharSet for duplicate Character
		Set<Character> dupCharSet=new HashSet<Character>();

//		Iterate character array and add it into charSet
		for(int i=0;i<cArray.length;i++)
		{
			if(!charSet.contains(cArray[i]))
			charSet.add(cArray[i]);
			else
				dupCharSet.add(cArray[i]); //if the character is already in the charSet then, add it to the dupCharSet
			
		}

//		Check the dupCharSet elements and remove those in the charSet
		
		System.out.println("CharSt values "+charSet);
		System.out.println("Duplicate CharSt values "+dupCharSet);
		
		
	List<Character> list = new ArrayList<Character>(charSet);
		 for (char character : dupCharSet) {
			for (int i = 0; i < list.size(); i++) {
				if (character==list.get(i)) {
					list.remove(i);
				}
			}
			}
		
		
		System.out.println("CharSt values "+list);
		System.out.println("Duplicate CharSt values "+dupCharSet);


//		print it


	}

}
