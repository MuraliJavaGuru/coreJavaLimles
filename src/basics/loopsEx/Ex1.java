package basics.loopsEx;

import java.util.Scanner;

public class Ex1 {
public static void main(String[] args) {
	System.out.println("enter size");
	Scanner sc = new Scanner(System.in);
	int size= sc.nextInt();
	
	int sum =0;
	for(int i=1;i<=size;i++) {
		System.out.println("enter num");
		int num = sc.nextInt();
		sum = sum + num;
	}
	System.out.println(sum);
}
}
