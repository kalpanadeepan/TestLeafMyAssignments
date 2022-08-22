package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class ArrayListLearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);list.add(22);list.add(3);list.add(54);list.add(65);list.add(22);list.add(43);
		int num=22,c=0;
		for(int i=0;i<list.size();i++)
		{
			if(num==list.get(i))
			{
				c++;
			}
		}System.out.println("The count is "+c);
		
		List<String> name=new ArrayList<String>();
		name.add("kalpana");
		name.add("seyon");
		name.add("deepa");
		name.add("selva");
		name.add("sekra");
		System.out.println("The name start with s is ");
		for(int i=0;i<name.size();i++)
		{
			if(name.get(i).startsWith("s"))
			{
				System.out.println(name.get(i));
			}
		}

	}

}
