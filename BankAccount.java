package atmuto;
import java.util.Scanner;
class BankAccount{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 10000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your Name: ");
		this.name = sc.nextLine();
		System.out.println("\nEnter your Username: ");
		this.userName = sc.nextLine();
		System.out.println("\nEnter your Password: ");
		this.password = sc.nextLine();
		System.out.println("\nEnter your Account Number: ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration Successful. Please Log in to your Bank Account");
	}
	public boolean login() {
		boolean isLogin = false;
		Scanner sc=new Scanner(System.in);
		while( !isLogin) {
			System.out.println("\nEnter your username: ");
			String Username = sc.nextLine();
			if (Username.equals(userName)) {
				while(!isLogin) {
					System.out.println("\nEnter your password: ");
					String Password = sc.nextLine();
					if(Password.equals(password)) {
						System.out.println("\nLogin Successful");
						isLogin = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}else {
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	
	public void withdraw() {
		System.out.println("\nEnter Amount to Withdraw: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
			if(balance >= amount) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdral Successful.");
				String str = amount + "Rs Withdrawn\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("\nInsufficient Balance.");
			}
		}catch(Exception e) {
			
		}
		
	}
	
	public void deposit() {
		System.out.println("\nEnter Amount to Deposit: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
			if(amount <= 10000f) {
				transactions++;
				balance += amount;
				System.out.println("\nDeposit Successful.");
				String str = amount + "Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("\nSorry. The limit is 10000.");
			}
		}catch(Exception e) {
			
		}
		
	}
	
	public void transfer() {
	    Scanner sc=new Scanner(System.in); 
		System.out.println("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.println("\nEnter Amount to transfer: ");
		float amount = sc.nextFloat();
		try {
			if(balance>= amount) {
			if(amount <= 50000f) {
				transactions++;
				balance -= amount;
				System.out.println("\nSuccesfully Transferred to "+ receipent);
				String str = amount + "Rs transferred to " + receipent+"\n";
				transactionHistory = transactionHistory.concat(str);
			}else {
				System.out.println("\nSorry. The limit is 50000.");
			}
		}else{
			System.out.println("\nInsufficient Balance.");
		}}catch(Exception e) {
		}		
		}
		
	public void checkBalance() {
		System.out.println("\n"+balance+"Rs");
	}
	
	public void transHistory() {
		if(transactions ==0) {
			System.out.println("No TRansactions happened");
		}else {
			System.out.print("\n"+transactionHistory);
		}
	}
}
