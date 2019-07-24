package bankaccount;

public class Checking extends Account {
	private int debitCardNumber;
	private int debitCardPin;
	public Checking(String name, String ssn, double initialDeposit, String dateStart) {
		super(name,ssn,initialDeposit,dateStart);
		accountType = "Checking";
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	@Override
	public void setRate() {
		rate = getBaseRate()*.15;
	}
	private void setDebitCard() {
		debitCardNumber = (int)(Math.random()*Math.pow(10, 12));
		debitCardPin = (int)(Math.random()*Math.pow(10, 4));
	}
		
	public void showInfo() {
		System.out.println("Checking account");
		super.showInfo();
		System.out.println("Card: "+this.debitCardNumber+"\nPIN: "+this.debitCardPin);


	}
}
