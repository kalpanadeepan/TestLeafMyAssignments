package org.bank;

public class BankInfo extends AxisBank{
	
	public void saving()
	{
		System.out.println("This is Savings Account");
	}
	
	public void fixed()
	{
		System.out.println("This Fixed Account");
	}
	public void deposit()
	{
		System.out.println("This is Deposit Account");
		super.deposit();
	}

}
