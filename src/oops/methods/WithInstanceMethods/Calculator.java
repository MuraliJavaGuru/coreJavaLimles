package oops.methods.WithInstanceMethods;
/*

1.take 2 nums and perform operations

2.	Create a calculator class
	and provide
	4 methods:
	sum()
	sub()
	mul()
	div()

1.Calculator   -> sum(), sub(), mul() , div()
2.TestCalcualtor  -> main()

#Approach#2:
 create class with instance variables for n1 and n2
 provide methods for every operation  by accessing the instance variables
 
 #instance method can access the instance variables
 * */

public class Calculator {
	// instance variables
	int n1;
	int n2;

	public void sum() {
		System.out.println("sum = "+( n1+n2));
	}

	public void sub() {
		System.out.println("sub = "+( n1- n2));
	}

	public void mul() {
		System.out.println("mul = "+ (n1*n2));
	}

	public void div() {
		System.out.println("div = "+ ( n1/n2));
	}
	
	

	
	
	
	
	
	
	
	
}
