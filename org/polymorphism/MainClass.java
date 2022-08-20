package org.polymorphism;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Students std=new Students();
		std.getStudentInfo();
		std.getStudentInfo(12);
		std.getStudentInfo(12, "kalpana");
		std.getStudentInfo("abc@gmail.com", 12);
	}

}
