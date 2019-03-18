package oops.methodEx;

public class TestPersonWithShowMethodCommon {
	public static void main(String[] args) {
		//create obj
		Person p1 = new Person();
		p1.id= 1000;
		p1.name = "user1";
		p1.age= 30;
		
		Person p2 = new Person();
		p2.id= 1001;
		p2.name = "user2";
		p2.age= 31;
		
		Person p3 = new Person();
		p3.id= 1002;
		p3.name = "user3";
		p3.age= 32;
		
		
		show(p1);
		show(p2);
		show(p3);
	}

	private static void show(Person Pobj) {
		System.out.println(Pobj.id);
		System.out.println(Pobj.name);
		System.out.println(Pobj.age);
	}

}
