package week3.day2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="testleaf";
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		//char[] cArray=str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for(Entry<Character,Integer> eachCount:entrySet)
		{
			System.out.println("The Charactor is "+eachCount.getKey()+" Count is "+eachCount.getValue());
		}
				

	}

}
