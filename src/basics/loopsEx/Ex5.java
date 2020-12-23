package basics.loopsEx;

import java.util.Scanner;

/**
 Take the names as input continuosly 
if the input value is "end"
then stop taking the inputs and print what are the names entered so far

Input:
-----------------
Enter name::
user1
Enter name::
kumar
Enter name::
raju
Enter name::
ramana
Enter name::
end

Output:
-------------------
names == user1 kumar raju ramana

use for loop when we know the size ( no of iterations)
use for while or do while when we dont know the size

 */
public class Ex5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = "";
		String input ="";
		while (!input.equals("end")) {
			result = result + " " +input;
			System.out.println("Enter name::");
			input = sc.next();
		}
		System.out.println("names ==" + result);
	}
}
