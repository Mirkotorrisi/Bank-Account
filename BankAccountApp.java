package bankaccount;

public class BankAccountApp {

	public static void main(String[] args) {
		Checking chk1 = new Checking("Dio Porco","123456789",1500);
		chk1.showInfo();
		Savings sv1 = new Savings("Cristo Merda","456875984",2000);
		sv1.showInfo();
	}

}
