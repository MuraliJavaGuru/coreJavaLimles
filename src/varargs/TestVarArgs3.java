package varargs;

/**
  Req:
  write a var arg function for printing multiple int.
 */
public class TestVarArgs3 {
	public static void main(String[] args) {
		System.out.println("------------display-----");
		display(1);
		display(1,2,3,4,5);
		display(10,2,1,2,4,56,2,64,2,47,3,47,46,57); 
		display(24 , 4);
	}

	public static void display(int... data){
		System.out.println("*******************************");
		for(int v: data){
			System.out.println(v);
		}
	}
}



















/*

public static void display2(int... data){
	 
}
ex:
display2(7)
display2(1,2,3,4,5,6,7)


public static void display3(float... data){
	 
}
ex: 
display3(12.67,24.242)
display3(24.45,353.3435,35353.33,1.0)


//here 1st arg is int , second arg is var-arg argument. 
public static void display4(int x, String... data){
	 
}
ex:
display4(4, "hello","hi","ram");
display4(5, "kumar");
display4(20, "user1", "user6", "user2", "user4", "user4",);



public static int getSum1(List<String>... str){
		System.out.println(str);
		int sum= 0;
		return sum;
	}
*/
