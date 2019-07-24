package bankaccount;

public class Savings extends Account {
	private int safetyDepositBoxKey;
	private int safetyDepositBoxID;
	public Savings(String name, String ssn, double initialDeposit, String dateStart) {
		super(name, ssn,initialDeposit, dateStart);
		accountType = "Savings";
		accountNumber = "1" + accountNumber;
		setSafetyDepositBox();
	}
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
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
