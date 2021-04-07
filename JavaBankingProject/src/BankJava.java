import java.io.*;
import java.util.*;

public class BankJava {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		ArrayList<BankAccount> userList=new ArrayList<>();
		ArrayList<BankAccount> payee=new ArrayList<>();
		
		int choice = 0;
		
		do {
			
			System.out.println("***Welcome To T.D Bank***\n        *****");
			System.out.println("0.Exit.");
			System.out.println("1.To create an account.\n2.Display Account Details.\n3.Deposit Money\n4.Withdraw Money\n5.Transfer money to other accounts within the bank\n6.Pay utility bills");
			 choice = sc.nextInt();
			
			switch(choice) {
			case 1:
				createNewAccount(userList);
				break;
			case 2:
		         readFromFile(userList);
				printList(userList);
				break;
				
			case 3:
				
				readFromFile(userList);
		         printList(userList);
		         depositMoney(userList);
		         break;
				
			case 4:
		         readFromFile(userList);
		         printList(userList);
		         withdrawMoney(userList);
		         break;
		         
			case 5:
		         readFromFile(userList);
		         printList(userList);
		         do {
		        	 
		        	  getpayee(payee);
		         }while(payee.isEmpty());
		         transferMoney(userList);
		         
		        
		       
		       
		         break;
			
			case 6:
		         readFromFile(userList);
		         printList(userList);
		         System.out.println("Choose bill type for the payment: \n 1. Electricity Bill \n 2. Broadband Bill \n 3. Rent");
		         payBill(userList);
		         break;
			
			}
		}while(choice!=0);
		
	
		

	}
	//method to read the details of the customers entered by the user
	//fill the details in the list and finally fill the list into a text file
	public static void createNewAccount(ArrayList<BankAccount> userList) throws IOException {
		
		//create a new file named users.txt, if the file exists will be overwritten
		FileWriter usr = new FileWriter("users.txt",true);
		PrintWriter pw=new PrintWriter(usr);
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Your ID:");
		int id=sc.nextInt();
		System.out.println("Enter the first name:");
		String first=sc.next();
		System.out.println("Enter the last name:");
		String last=sc.next();
		
		System.out.println("Enter type of account to be created (savings/ current):");
		sc.nextLine();
		String accountType=sc.nextLine();
		System.out.println("Enter the age:");
		int age=sc.nextInt();
		System.out.println("Enter the amount you want to deposit in your account");
		double deposit=sc.nextDouble();
		BankAccount ft=new BankAccount(id,first,last,accountType,deposit,age);
		userList.add(ft);
		pw.println(ft.writeToFile());
		System.out.println("Account Created Successuly");
		pw.close();
	}
	
	//a method to read form the file and then do whatever
	//here we will read form the file and fill the array list
	public static void readFromFile(ArrayList<BankAccount> userList) throws IOException
	{
		FileInputStream userFile=new FileInputStream("users.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(userFile));
		Scanner sc=new Scanner(System.in);
		
		BankAccount ft;
		String line;
		
		int accountId;
		
		System.out.println("Enter Your Account ID:");
		
		accountId = sc.nextInt();
		
		
		while((line=br.readLine())!=null) {
			String fields[]=line.split(",");
			int id=Integer.parseInt(fields[0]);
			String fullName=fields[1];
			String names[]=fullName.split(" ");
			String accountType=fields[2];
			double deposit=Double.parseDouble(fields[3]);
			int age=Integer.parseInt(fields[4]);
		
			if(accountId == id) {
				ft=new BankAccount(id,names[0],names[1],fields[2],deposit,age);
				userList.add(ft);
				
			}
			
			
			
			
			
		}
		
		if(userList.isEmpty())
		{
			System.out.println("No Account Found");
			
		}
		
		
		
		
		
	}
	
	public static void getpayee(ArrayList<BankAccount> payee) throws IOException
	{
		FileInputStream userFile=new FileInputStream("users.txt");
		BufferedReader br=new BufferedReader(new InputStreamReader(userFile));
		Scanner sc=new Scanner(System.in);
		
		BankAccount ft;
		String line;
		
		int accountId;
		
		System.out.println("Enter Payee Account ID:");
		
		accountId = sc.nextInt();
		
		
		while((line=br.readLine())!=null) {
			String fields[]=line.split(",");
			int id=Integer.parseInt(fields[0]);
			String fullName=fields[1];
			String names[]=fullName.split(" ");
			String accountType=fields[2];
			double deposit=Double.parseDouble(fields[3]);
			int age=Integer.parseInt(fields[4]);
		
			if(accountId == id) {
				ft=new BankAccount(id,names[0],names[1],fields[2],deposit,age);
				payee.add(ft);
				System.out.println("Payee Found");
				
				
			}
			
			
			
			
			
		}
		
		if(payee.isEmpty())
		{
			System.out.println("No Payee Found");
			
		}
		
		
		
		
		
	}
	
	
	
	//print the content of the array list
	public static void printList(ArrayList<BankAccount> userList) {
		for(BankAccount usr:userList)
			System.out.println(usr);
		
	}
	
	

	
		
	
	
	public static void withdrawMoney(ArrayList<BankAccount> userList) {
		double withdrawalAmount;
	    double updatedBalance = 0;
		Scanner sc = new Scanner(System.in);
		
	
		if(!userList.isEmpty())
		{
			System.out.println("How Much Money you want to Withdraw ?");
			
		}
		
		
		withdrawalAmount = sc.nextDouble();
		
		
		
		for(BankAccount usr:userList)
		{
			if(usr.deposit<withdrawalAmount)
			{
				
				System.out.println("Insufficient Balance");
			}
			
			else
			{
				updatedBalance = usr.deposit - withdrawalAmount;
				System.out.println("Your Updated Balance is: "+updatedBalance);
				
			}
			
		}
		
		}
		
	public static void depositMoney(ArrayList<BankAccount> userList) {
			double depositAmount;
		    double updatedBalance = 0;
			Scanner sc = new Scanner(System.in);
			
			
			if(!userList.isEmpty())
			{
				System.out.println("How Much Money you want to deposit ?");
				
			}
			
			
			depositAmount = sc.nextDouble();
			
			
			
			for(BankAccount usr:userList)
			{
				
					updatedBalance = usr.deposit + depositAmount;
					System.out.println("Your Updated Balance is: "+updatedBalance);
				
				
				
				
			}
	}
	
	
	public static void transferMoney(ArrayList<BankAccount> userList) {
		double amountToTransfer;
	    double updatedBalance = 0;
	    Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		int ran_int = ran.nextInt(99999);
		
	
		if(!userList.isEmpty())
		{
			System.out.println("How Much Money you want to Tranfer ?");
			
		}
		
		
		amountToTransfer = sc.nextDouble();
		
		
		
		for(BankAccount usr:userList)
		{
			if(usr.deposit<amountToTransfer)
			{
				
				System.out.println("Insufficient Balance");
			}
			
			else
			{
				updatedBalance = usr.deposit - amountToTransfer;
				System.out.println("Transaction Completed Successfully. \n Your Transaction no. is "+ran_int);
				System.out.println("Your Updated Balance is: "+updatedBalance);
				
			}
			
		}
		
		}
	
			
       
	public static void payBill(ArrayList<BankAccount> userList) {
				double billAmount;
			    double updatedBalance = 0;
			     
				Scanner sc = new Scanner(System.in);
	
				System.out.println("Enter bill type:");
				int choice = Integer.parseInt(sc.nextLine());
		        
			  
			  
			  if(choice == 1)
				  
				  System.out.println("You have selected electricity bill ");
			  
			  else if(choice == 2) {
				  
				  System.out.println("You have selected broadband bill ");
			  }
			  else if(choice == 3) {
				  System.out.println("You have selected rent ");
			  }
			
				if(!userList.isEmpty())
				{
					System.out.println("Enter amount to pay the selected bill: ");
					
				}
				
		
				
		
				billAmount = sc.nextDouble();
				
				
				
				for(BankAccount usr:userList)
				{
					
					
						
  					  if(usr.deposit<billAmount)
					{
						
						System.out.println("Insufficient Balance");
					}
					
				
					else
					{
						updatedBalance = usr.deposit - billAmount;
						System.out.println("Bill payment successful  !!!!!!!");
						System.out.println("Your Updated Balance is: "+updatedBalance);
						
						
					}

			
				
				
				}
	}
		
	}
	
	
	
	

