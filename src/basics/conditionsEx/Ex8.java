package conditions;
 
/**
  take bankname(string) as input ,
  
  if bankname value is "sbi"  o/p => ROI = 10%
  
  if bankname value is "icici"  o/p => ROI = 11%  
  
  if bankname value is "hdfc"  o/p => ROI = 12%  
  
  if bankname value is "citi"  o/p => ROI = 13%  
  
  other than this o/p => invalid bank
  
  
  solution:
  ---------------
  - use if and else if
  - at a time only one condition is satisfied.
  - there is a dependency between conditions
 */
import java.util.Scanner;

public class Ex8 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	System.out.println("enter bank name in lower case:");
	String bankName = sc.next();
	
	
	if(bankName.equals("sbi")) {
		System.out.println(" ROI = 10%");
	}
	else if(bankName.equals("icici")) {
		System.out.println(" ROI = 11%");
	}
	else if(bankName.equals("hdfc")) {
		System.out.println(" ROI = 12%");
	}
	else if(bankName.equals("citi")) {
		System.out.println(" ROI = 13%");
	}
	else {
		System.out.println("Invalid bank");
	}
}
}
