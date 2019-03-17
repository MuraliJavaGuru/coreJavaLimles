package threads2;

import java.util.Scanner;

public class TestWithThread {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);

	//	System.out.println("Enter 2 nums");
		int num1 = 50;//sc.nextInt();
		int num2 = 10;//sc.nextInt();
		
		CalculatorThread t1 = new CalculatorThread("add", num1, num2);
		CalculatorThread t2 = new CalculatorThread("sub", num1, num2);
		CalculatorThread t3 = new CalculatorThread("mul", num1, num2);
		CalculatorThread t4 = new CalculatorThread("div", num1, num2);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

		Thread.sleep(3000);
		System.out.println("end");
		 
	}

}
