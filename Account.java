package bankaccount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Account implements IBaseRate{
	private String name;
	private String ssn;
	protected String accountNumber;
	protected double rate;
	private double balance;
	private static int index = 10000;
	protected static String accountType;
	private String dateStart;
	public Account(String name, String ssn, double initialDeposit, String dateStart) {
		this.name = name;
		this.ssn = ssn;
		this.dateStart = dateStart;
		setBalance(initialDeposit);
		this.accountNumber = setAccountNumber();
		index++;
		setRate();
	}
	public abstract void setRate();
	
	public void compound(String dateStart, double balance) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
		Date d1 = null;
		d1 = format.parse(dateStart);
		long today = new java.util.Date().getTime();
		long diff = today - d1.getTime();
		float diffYear = (diff/(24*60*60*1000)/365);
		double accumulatedAmount = Math.pow((rate/100) + 1, diffYear)*balance;
		System.out.println("Balance: "+ balance);
		System.out.println("Rate: "+ rate);
		System.out.print("Interests from " + dateStart +" to "+ (format.format(today))+" : ");
		System.out.printf("%.2f", (accumulatedAmount - balance));
		setBalance(accumulatedAmount);
		System.out.print("\nNew Balance: ");
		System.out.printf("%.2f", accumulatedAmount);


	}
	
	private String setAccountNumber() {
		String lastTwoOfSSN = getSsn().substring(getSsn().length()-2,getSsn().length());
		int uniqueID = index;
		int rand = (int) (((Math.random()+1) * 1000));

		return lastTwoOfSSN + uniqueID + rand;
	}
	
	public void deposit(double amount) {
		setBalance(getBalance() + amount);
		System.out.println("Depositing "+amount+"$");


	}
	public void widthdraw(double amount) {
		if(amount < getBalance()) {
		setBalance(getBalance() - amount);
		System.out.println("Widthdrawing "+amount+"$");

		}
		else {
			System.out.println("Insufficient funds");

			}
		}
	public void showInfo() {
		System.out.println("NAME: "+getName()+"\nACC NUM: "+ accountNumber +"\nBALANCE: "+getBalance()
							+"\nACCOUNT OPENED IN: "+dateStart+"\nRATE: "+rate+"%");

	}
	public String getDateStart() {
		return dateStart;
	}
	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public String getSsn() {
		return ssn;
	}
	public String getAccountType() {
		return accountType;
	}

		
	}
	
