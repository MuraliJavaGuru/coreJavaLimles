package java8Features.lambdaAndForEach;

import java.util.*;
//print all
public class TestForEach1 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("user1");
		list.add("user2");
		list.add("user3");
		list.add("user4");
		list.add("user11");
		list.add("user21");
		list.add("user33");
		
		//print all
		System.out.println("************************print using enhanced for loop************************");
		for(String data :list ) {
			System.out.println(data);
		}
		
		
		System.out.println("************************print using forEach approach2 ******************************");
		list.forEach( data -> System.out.println(data));
	}
}








/*
 System.out.println("************************print using forEach approach1 ******************************");
		list.forEach((String data)  -> {
			System.out.println(data);
		}
		);
 * */
