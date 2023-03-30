package in.ineuron.Bank;

import java.util.Scanner;

public class Bank {
	int balance=1000;
	int TransactionHistory;
	
	public void checkBalance()
	{
		System.out.print(balance);
	}

	void deposit(int amount) {
		if(amount != 0) {
			balance = balance + amount;
			TransactionHistory = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount<=balance) {
			balance = balance - amount;
			TransactionHistory = -amount;
			System.out.println();
			System.out.print("Transaction successful");
		}
		else
		{
			System.out.print("Insufficient Funds ");
		}
	}
	void transfer(int amount)
	{
		if(amount<=balance)
		{
			balance=balance - amount;
			TransactionHistory=-amount;
			System.out.println();
			System.out.print("Transaction successful");
			
		}
		else
		{
			System.out.print("Insufficient Funds ");
		}
	}

	public void exit()
	{
		System.out.println("Thanks for using our Banking Services....");
		System.exit(0);
		
	}
	
public void showMenu() {
		
		int option = 0;
		Scanner scanner = new Scanner(System.in);
		
		String name = "Welcomee to iNeuron Banking Application";

		try
		{
			for(int i=0;i<name.length();i++)
			{
				System.out.print(name.charAt(i));
				Thread.sleep(30);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println();
		
		
		
		System.out.println("1 : Check Your Balance");
		System.out.println("2 : Deposit");
		System.out.println("3 : Withdraw");
		System.out.println("4 : Transfer");
		System.out.println("5 : Exit The System");
		
		do {
			System.out.println("");
			System.out.println("**** PLEASE SELECT A OPTION ****");
			System.out.println();
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch (option) {
			
			case '1':
				System.out.println("-------------------------------------------------------");
				checkBalance();
				System.out.println("-------------------------------------------------------");
				
				break;
				
			case '2':
				System.out.println("-------------------------------------------------------");
				System.out.println("Enter an amount to deposit ");
				System.out.println("-------------------------------------------------------");
				
				int amount = scanner.nextInt();
				deposit(amount);
				
				break;
				
			case '3':
				System.out.println("-------------------------------------------------------");
				System.out.println("Enter an amount to withdraw ");
				System.out.println("-------------------------------------------------------");
				
				int amount2 = scanner.nextInt();
				withdraw(amount2);
			
				break;
				
			case '4':
				System.out.println("-------------------------------------------------------");
				System.out.println("Enter an amount to Transfer ");
				System.out.println("-------------------------------------------------------");
				
				int amount3 = scanner.nextInt();
				transfer(amount3);
				
				break;	
				
			case '5':
				System.out.println("-------------------------------------------------------");
				exit();
				System.out.println("-------------------------------------------------------");
				break;
				
				default:
				System.out.println("Invalid Option!! Please Enter Correct Opton...");
				break;
			}			
		}
		while(option>5);
			System.out.println("Thank You for Using our Services.....!!");
 }
}
