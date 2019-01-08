package Branch;

import java.util.HashMap;

import java.util.Scanner;

import Account.Account;
import Account.CurrentAccount;
import Bank.BankManager;
import CustomerActivity.CustomerDetails;

public class Branch 
{
	
	int accountId;
	String name;
	
	public Branch(int custid, String name)
	{
		this.accountId = custid;
		this.name= name;
	}
	
	public String getName() 
	{
		return name;
	}

	
	
	BankManager b=new BankManager();
	
	public static HashMap<Integer,CustomerDetails> customerMap=new HashMap<>();
	boolean stop=false;
	private static int choice;
	private Scanner sc=new Scanner(System.in);
	
	
	public void addCustomer()
	{	
		
		
		System.out.println("Enter Customer Name");
		String name=sc.nextLine();
		System.out.println("Enter MailId");
		String mailId=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		System.out.println("Enter MobileNumber");
		String mobileNumber=sc.nextLine();
		
		
		System.out.println("Choose Account Type");
		System.out.println("1.Current Account");
		System.out.println("2.Savings Account");
		System.out.println("3.Loan Account");
		
		choice=sc.nextInt();
		
		if(choice==1)
	
		{
			System.out.println("Enter Initial Amount");
			double amount=sc.nextDouble();
			Account account = new CurrentAccount(amount);
			CustomerDetails customer = new CustomerDetails(accountId,name,mailId,password,getName(),mobileNumber,"CurrentAccount",amount,account);
			customerMap.put(accountId, customer);
			accountId++;
			
			//transactionhistory
			//viewCustomer();
			b.Menu();
		
		}
		else if(choice==2)
		{
			do {
			System.out.println("Enter Initial Amount (Minimum 1000rs)");
			double amount=sc.nextDouble();
			if(amount>=1000) 
			{
				Account account = new CurrentAccount(amount);
				CustomerDetails customer = new CustomerDetails(accountId,name,mailId,password,getName(),mobileNumber,"SavingsAccount",amount,account);
				customerMap.put(accountId, customer);
				accountId++;
				stop=false;
			}
			}
			while(stop==true);
			
			b.Menu();
		}
			
		else if(choice==3)
			{
				System.out.println("Enter Initial Amount");
				double amount=sc.nextDouble();
				Account account = new CurrentAccount(amount);
				CustomerDetails customer = new CustomerDetails(accountId,name,mailId,password,getName(),mobileNumber,"LoanAccount",amount,account);
				customerMap.put(accountId, customer);
				accountId++;
				b.Menu();
			}
		
		
	
	}


	public void deleteCustomer()
	{
		System.out.println("Enter AccountId");
		accountId=sc.nextInt();
		for(CustomerDetails customer : Branch.customerMap.values()) 
		{
			if(customer.getAccountId()==(accountId))
			{
				customerMap.remove(customer.getAccountId());
				System.out.println(customer.getaccountBalance()+ " "+customer.getbranch());
			}
		}
	
	}
	
	public void viewCustomer()
	{
		System.out.println("Enter AccountId");
		accountId=sc.nextInt();
		
		for(CustomerDetails customer : Branch.customerMap.values()) 
		{
			if(customer.getAccountId()==(accountId))
			{
				System.out.println(customer.getaccountBalance()+ " "+customer.getbranch());
			}
		}
	}
	
	public void viewAllCustomer()
	{
		for(CustomerDetails customer : Branch.customerMap.values()) 
		{
			if(customer.getbranch().equals(getName()))
			{
				System.out.println(customer.getAccountId()+" "+customer.getaccountBalance()+ " "+customer.getbranch());
			}
		}
		b.Menu();
	}
	

}
