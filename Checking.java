package bankaccount;

public class Checking extends Account {
	int debitCardNumber;
	int debitCardPin;
	public Checking(String name, String ssn, double initialDeposit) {
		super(name,ssn,initialDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	private void setDebitCard() {
		debitCardNumber = (int)(Math.random()*Math.pow(10, 12));
		debitCardPin = (int)(Math.random()*Math.pow(10, 4));
		System.out.println("Card: "+this.debitCardNumber+"\nPIN: "+this.debitCardPin);
	}
		
	public void showInfo() {
		super.showInfo();
		System.out.println("Checking account");
	}
}
