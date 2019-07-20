package bankaccount;

public class Savings extends Account {
	int safetyDepositBoxKey;
	int safetyDepositBoxID;
	public Savings(String name, String ssn, double initialDeposit) {
		super(name, ssn,initialDeposit);
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	public void setSafetyDepositBox() {
		safetyDepositBoxID = (int)((Math.random()+1)*100);
		safetyDepositBoxKey = (int)((Math.random()+1)*1000);
	}
	public void showInfo() {
		System.out.println("Savings account");
		super.showInfo();
		System.out.println("Saftey Deposit box: "+safetyDepositBoxID+"\nSafety Deposit Box KEY: "+safetyDepositBoxKey);
	}

}
