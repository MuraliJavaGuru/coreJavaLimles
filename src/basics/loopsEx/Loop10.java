package basics.loopsEx;

import java.util.Scanner;

/**
  1.take the input for a number
  2.find the odd numbers from 1 till the input
 */

public class Loop10 {
public static void main(String[] args) {
	//take THE input
	Scanner sc = new Scanner(System.in);
	System.out.println("enter number : ");
	int num = sc.nextInt();
	
	//process
	for(int i=1;i<=num ; i= i+2) {
			System.out.println(i);
	}
}
	
}

