package bankaccount;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BankAccountApp {

	public static void main(String[] args) throws ParseException, FileNotFoundException, UnsupportedEncodingException {

		List<Account> accounts = new LinkedList<Account>();

		String file = "C:\User\Desktop\file.csv";

		List<String[]> newAccounts = utilities.CSV.read(file); 
		for (String[]accountholders : newAccounts) {
			String name = accountholders[0];
			String ssn = accountholders[1];
			String accountType = accountholders[2];
			double initDeposit = Double.parseDouble(accountholders[3]);
			String dateStart = accountholders[4];
			if(accountType.equals("Savings")) {
				accounts.add(new Savings(name,ssn,initDeposit,dateStart));
			}
			else if (accountType.equals("Checking")){
				accounts.add(new Checking(name,ssn,initDeposit,dateStart));				
			}
			else {
				System.out.println("Error reading account type.");
			}
		}
		for(int i = 0; i < accounts.size() ; i++) {
			System.out.println("-------\naccount number: "+i);
			accounts.get(i).showInfo();
			System.out.println("---------");

		}
		Scanner inp = new Scanner(System.in);
		boolean bool = true;
		while (bool == true) {
			System.out.print("\n------------\n");
			System.out.println("1 - DEPOSIT - 2 - WIDTHDRAW - 3 - TRANSFER - 4 - GET INTERESTS - 5 - SHOW INFO - 6 - SAVE AND QUIT");
			int choice = inp.nextInt();

			if(choice == 1) {
				System.out.println("CHOOSE AN ACCOUNT: ");
				int acc = inp.nextInt();
				System.out.println("Insert amount: ");
				int amt = inp.nextInt();
				accounts.get(acc).deposit(amt);
				accounts.get(acc).showInfo();
				}
			else if(choice == 2){
				System.out.println("CHOOSE AN ACCOUNT: ");
				int acc = inp.nextInt();
				System.out.println("Insert amount: ");
				int amt = inp.nextInt();
				accounts.get(acc).widthdraw(amt);
				accounts.get(acc).showInfo();
				}
			else if(choice == 3){
				System.out.println("CHOOSE AN ACCOUNT: ");
				int acc = inp.nextInt();
				System.out.println("CHOOSE A BENEFICIARY: ");
				int ben = inp.nextInt();
				System.out.println("Insert amount: ");
				int amt = inp.nextInt();
				accounts.get(acc).widthdraw(amt);
				accounts.get(ben).deposit(amt);
				accounts.get(acc).showInfo();
				accounts.get(ben).showInfo();
				}
			else if(choice == 4){
				System.out.println("CHOOSE AN ACCOUNT: ");
				int acc = inp.nextInt();
				accounts.get(acc).compound(accounts.get(acc).getDateStart(), accounts.get(acc).getBalance());
				}
			else if(choice == 5){
				System.out.println("CHOOSE AN ACCOUNT: ");
				int acc = inp.nextInt();
				accounts.get(acc).showInfo();
				}
			else if(choice == 6){
				System.out.println("THANK YOU AND HAVE A NICE DAY");
				PrintWriter writer = new PrintWriter(file, "UTF-8");
				for(int n = 0; n < accounts.size(); n++) {
					writer.print(accounts.get(n).getName()+",");
					writer.print(accounts.get(n).getSsn()+",");
					writer.print(accounts.get(n).getAccountType()+",");
					writer.print(accounts.get(n).getBalance()+",");
					writer.print(accounts.get(n).getDateStart());
					writer.print("\n");
				}
				writer.close();
				inp.close();
				bool = false;
				}
		}
	}
	
}
