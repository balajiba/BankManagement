package Bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Branch.Branch;

import CustomerActivity.CustomerAction;
	
public class BankManager {
	
	private static Scanner sc=new Scanner(System.in);
	int index;
	int choice;
	public static ArrayList<Branch> branchList=new ArrayList<>();
	int customerStart=10000;
	static int indexValue=0;
	
	
	
	public void Menu()
	{
		System.out.println("1.Branch Account Operation");
		System.out.println("2.Add Branch");
		System.out.println("3.Delete Branch");
		System.out.println("4.View Branch");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			branchOperations();
			break;
		case 2:
			addBranch();
			break;
		case 3:
			deleteBranch();
			break;
		case 4:
			viewBranch();
			break;
		case 5:
			break;
			
		}
	}
	
	public void addBranch()
	{
		sc.nextLine();
		String branchname=sc.nextLine();
		Branch a=new Branch(customerStart, branchname);
		branchList.add(a);
		customerStart+=50000;
		Menu();
	}
	
	public void deleteBranch()
	{
		System.out.println(Arrays.toString(branchList.toArray()));
		index=sc.nextInt();
		branchList.remove(index);
	}
	public void viewBranch()
	{
		
			for(Branch list:branchList)
			{
				indexValue++;
				
				System.out.println(indexValue+"."+list.getName());
			}
				Menu();
				
	}
	
	
	public void branchOperations() 
	
	{
		indexValue=0;
		System.out.println("Select BranchName");
		
		for(Branch list:branchList)
		{
			indexValue++;
			System.out.println(indexValue+"."+list.getName());
		}
		
		index=sc.nextInt();
		
		Branch temp = branchList.get(index-1);
		
		System.out.println("1.View Customer Details");
		System.out.println("2.Add Customer");
		System.out.println("3.Delete Customer");
		System.out.println("4.Menu");
		
		choice=sc.nextInt();
		
		if(choice==1)
		
			temp.viewCustomer();
		
		else if(choice==2)
			
			temp.addCustomer();
		
		else if(choice==3)
		{
			temp.deleteCustomer();
		}
		else if(choice==4)
		{
			Menu();
		}
	
	}

	



}
