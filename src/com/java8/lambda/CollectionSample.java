package com.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionSample {
	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<>();
		ar.add(10);
		ar.add(14);
		ar.add(17);
		ar.add(3);
		ar.add(23);
		System.out.println("Not sorted : "+ar);
		Collections.sort(ar);
		System.out.println("Sorted Asc : "+ar);
//		Collections.sort(ar, new MyComparator());
		// Cannot use {} as it is not a functional interface
		Collections.sort(ar,(o1,o2) -> o1>o2 ? -1: o2>o1 ? 1 : 0);
		System.out.println("Sorted Desc : "+ar);
		
		// Without comparator Asecending order
		//With Comparator. SHould be done while initializing
//		TreeSet<Integer> treeSet = new TreeSet<>(new MyComparator());
		TreeSet<Integer> treeSet = new TreeSet<>((a,b) -> a>b?-1 : a<b?1 : 0);
		treeSet.add(10);
		treeSet.add(100);
		treeSet.add(121);
		treeSet.add(78);
		treeSet.add(123);
		treeSet.add(121);
		treeSet.add(78);
		
		System.out.println("TreeSet Unsorted : "+treeSet);
		
//		/Default TreeMap sorting order is ascending. Descending can be customized
//		Key of map is sorted
//		TreeMap<Integer, String> treeMap = new TreeMap<>(new MyComparator());
		TreeMap<Integer, String> treeMap = new TreeMap<>((x,y)-> x>y?-1 : x<y?1 : 0);
		treeMap.put(3, "Three");
		treeMap.put(1, "One");		
		treeMap.put(6, "Six");
		treeMap.put(4, "Four");
		treeMap.put(5, "Five");
		treeMap.put(2, "Two");
		System.out.println("treeMap Sorted : "+treeMap);
		
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(new Employee(12, 33253, "name1"));
		empList.add(new Employee(45, 57745, "gdfgf"));
		empList.add(new Employee(23, 36361, "dghhf"));
		empList.add(new Employee(87, 31346, "ddfhf"));
		empList.add(new Employee(45, 63636, "fdhhh"));
		System.out.println("empList  : "+empList);
		
		Collections.sort(empList,
				(emp1,emp2) -> emp1.getNumber()>emp2.getNumber()?-1 : emp1.getNumber()<emp2.getNumber()?1 : 0);
		System.out.println("empList Sorted By Number: "+empList);
		
//		Collections.sort(empList,
//				(emp1,emp2) -> emp1.getName().compareTo(emp2.getName())?-1 : emp1.getNumber()<emp2.getNumber()?1 : 0);
//		System.out.println("empList Sorted By Name: "+empList);
	}
}

class Employee{
	
	private int number;
	private long salary;
	private String name;
	/**
	 * @param number
	 * @param salary
	 * @param name
	 */
	public Employee(int number, long salary, String name) {
		super();
		this.number = number;
		this.salary = salary;
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public long getSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return String.format("Employee [number=%s, salary=%s, name=%s]", number, salary, name);
	}	
}

class MyComparator implements Comparator<Integer>{
	//2 4 1
	//-ve value o1 before o2
	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o1>o2 ? -1: o2>o1 ? 1 : 0;
//		if(o1==o2)
//			return 0;
//		if(o1<o2)
//			return 1;
//		else
//			return -1;
	}
	
}
