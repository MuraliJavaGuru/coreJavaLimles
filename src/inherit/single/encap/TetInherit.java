package inherit.single.encap;

public class TetInherit {
	public static void main(String[] args) {
		// create obj for person
		Person p = new Person();
		//use the set methods for setting the data
		p.setName("testUser2");
		p.setAge(50);
		p.setId(65556);

		System.out.println("*********************** person info *********************************");
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getAge());
		//p.displayPerson();
		
		
		//create obj for employee
		Employee emp = new Employee();
		//set data for inherited props
		emp.setName("testUser1");
		emp.setAge(45);
		emp.setId(12345);
		emp.setPan("bnadh671a6");
		emp.setPfNo("testPfNo");
		
		System.out.println("*********************** employee info *********************************");
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getAge());
		System.out.println(emp.getPan());
		System.out.println(emp.getPfNo());
		//emp.displayPerson();
		//emp.displayEmp();
	}
}
