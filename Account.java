package bankaccount;

public abstract class Account implements IBaseRate{
	String name,ssn, accountNumber;
	double rate,balance;
	static int index = 10000;
	public Account(String name, String ssn, double initialDeposit) {
		this.name = name;
		this.ssn = ssn;
		balance = initialDeposit;
		this.accountNumber = setAccountNumber();
		index++;
	}
	private String setAccountNumber() {
		String lastTwoOfSSN = ssn.substring(ssn.length()-2,ssn.length());
		int uniqueID = index;
		int rand = (int) (((Math.random()+1) * 1000));

		return lastTwoOfSSN + uniqueID + rand;
	}
	public void showInfo() {
		System.out.println("NAME: "+name+"\nACC NUM: "+ accountNumber+"\nBALANCE: "+balance);
	}
}
