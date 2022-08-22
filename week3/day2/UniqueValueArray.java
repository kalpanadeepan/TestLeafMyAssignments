package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class UniqueValueArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {1,22,3,54,65,22,43,67,98,1};
		
		List<Integer> l=new ArrayList<Integer>();
		
		for(int i=0;i<a.length;i++)
		{
			if(!l.contains(a[i]))
			{
				l.add(a[i]);
			}
			else
			{
				System.out.println(a[i]);
			}
		}
		
		

	}

}
