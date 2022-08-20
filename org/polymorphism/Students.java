package org.polymorphism;

public class Students {

	public void getStudentInfo()
	{
		System.out.println("The argument method");
	}
	
	public void getStudentInfo(int id)
	{
		System.out.println("The one argument method "+id);
	}
	public void getStudentInfo(int id ,String name)
	{
		System.out.println("The two argument method "+ id+ "Name is"+ name);
	}
	public void getStudentInfo(String email, long phone)
	{
		System.out.println("The two argument method "+email+"The phoneNumber "+phone);
	}
	
}
