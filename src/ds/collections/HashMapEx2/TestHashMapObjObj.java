package ds.collections.HashMapEx2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class TestHashMapObjObj {
	public static void main(String[] args) {
		Map<Employee, Project> map = new HashMap<>();
		
		Employee e1 = new Employee("user1",1);
		Employee e2 = new Employee("user2",2);
		Employee e3 = new Employee("user3",3);
		
		Project p1 = new Project(12,"pro1");
		Project p2 = new Project(13,"pro2");
		Project p3 = new Project(14,"pro3");
		
		//keep the data in map
		map.put(e1, p1);
		map.put(e2, p2);
		map.put(e3, p3);
		
		System.out.println("**** print map  ****");
		printMap(map);
		
		System.out.println("**** add e4  ****");
		Employee e4 = new Employee("user3",3);
		Project p4 = new Project(1555,"pro555");
		map.put(e4, p4);
		
		System.out.println("**** print map  ****");
		printMap(map);
		
		System.out.println(map.get(e1));
		System.out.println(map.get(e2));
		System.out.println(map.get(e3));
		
		
		//1. create new obj ; and search in map
		Employee e5 = new Employee("user2",2);
		System.out.println(map.get(e5));
		
		System.out.println(" ****contains e5*****");
		System.out.println(map.containsKey(e5));
		
		System.out.println(" ****remove  e5*****");
		map.remove(e5);
		
		System.out.println("*****get e2******");
		System.out.println(map.get(e2));
		
		
	}

	private static void printMap(Map<Employee, Project> map) {
		for(Entry<Employee, Project> entry :  map.entrySet()) {
			Employee e = entry.getKey();
			Project p = entry.getValue();
			
			System.out.println("key= "+e + " , value=" + p);
		}
	}
}

