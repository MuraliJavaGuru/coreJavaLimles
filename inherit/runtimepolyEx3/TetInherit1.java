package inherit.runtimepolyEx3;

import java.util.Scanner;

public class TetInherit1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your sal bank:");
		String salBank = sc.next();

		RBIBank r = null;

		if (salBank.equals("hdfc")) {
			r = new Hdfc();
		} else if (salBank.equals("sbi")) {
			r = new SBI();
		} else if (salBank.equals("icici")) {
			r = new Icici();
		} else {
			r = new RBIBank();
		}

		r.createAccount();
		r.processLoan(); 
		 
	}
	
	
	
}