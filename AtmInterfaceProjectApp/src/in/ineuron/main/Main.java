package in.ineuron.main;

import in.ineuron.bank.Bank;
import java.util.Scanner;
import in.ineuron.bank.AccountHolder;

public class Main {

	public static void main(String[] args) 
	{
	
		String bank = "===========WELCOME TO iNEURON BANK===============";
		try
		{
			for(int i=0;i<bank.length();i++)
			{
				System.out.print(bank.charAt(i));
				Thread.sleep(30);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println();
		
		
		Bank b = new Bank();
        b.initiate();
        
		AccountHolder cc=new AccountHolder();
		cc.customer();
		
		
	}

}