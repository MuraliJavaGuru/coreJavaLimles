package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmpListSort2 {
	public static void main(String[] args) {
		// sorting object array
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(10, "Murali", 25, 10000));
		empList.add(new Employee(50, "Arun", 29, 20000));
		empList.add(new Employee(6, "lakshman", 35, 5000));
		empList.add(new Employee(7, "lalith", 32, 50000));

		 
		 // sorting by id employees array using Comparable interface
		System.out.println("before :");
		show(empList);
		System.out.println("\n\nsorting based on id:------");
		Collections.sort(empList);
		show(empList);
		
		System.out.println("\n\nsorting based on name:------");
	    Comparator<Employee> aComparator = new Comparator<Employee>() {
		        @Override
		        public int compare(Employee e1, Employee e2) {
		            return e1.getName().compareTo(e2.getName());
		        }
		    };
		Collections.sort(empList,aComparator);
		show(empList);
		
		
		System.out.println("\n\nsorting based on age:------");
		Comparator<Employee> ageComp = new Comparator<Employee>() {
	        @Override
	        public int compare(Employee e1, Employee e2) {
	            return e1.getAge()- e2.getAge();
	        }
	    };
	    Collections.sort(empList,ageComp);
	    show(empList);
	
		
		
		System.out.println("\n\nsorting based on sal:------");
		Comparator<Employee> salComp = new Comparator<Employee>() {
	        @Override
	        public int compare(Employee e1, Employee e2) {
	            return (int)(e1.getSalary()- e2.getSalary());
	        }
	    };
	    Collections.sort(empList,salComp);
	    show(empList);

	}

	private static void show(List<Employee> empList) {
		System.out.println("\n");
		for (Employee emp : empList) {
			System.out.println(emp);
		}
	}
}

