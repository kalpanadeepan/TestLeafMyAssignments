package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class CollectionsDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> li=new ArrayList<Integer>();
		// TODO Auto-generated method stub
				List<Integer> l=new ArrayList<Integer>();
		li.add(1);li.add(22);li.add(3);
		li.add(54);li.add(65);li.add(22);li.add(43);li.add(67);li.add(98);li.add(1);
		System.out.println("The List values "+li);
		
		
		for(int i=0;i<li.size();i++)
		{
			if(l.contains(li))
			{
				continue;
			}else
			{
				l.add(li.get(i));
			}
		}
		System.out.println("The Result is "+l);

	}

}
