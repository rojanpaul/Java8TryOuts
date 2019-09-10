package com.java8.predefinedFunctions.specialcases;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class TwoArgFnInterfacetest {
	public static void main(String[] args) {
		/**
		 * BiPredicate can take two arguments for conditional check
		 * ALL default methods(andThen(), or(), negate()) 
		 *  But NO static methods like isEqual() available
		 */
		BiPredicate<Integer, Integer> biPredicate = (i1,i2)-> i1>i2;
		System.out.println("biPredicate.test(3, 5) : "+biPredicate.test(3, 5));
		
		/**
		 * BiFunction can take two arguments for processing
		 * Default function andThen() is only available
		 * No compose() function available
		 */
		BiFunction<Integer, Integer, String> biFunction = (i1,i2) -> i1>i2?"First Number Greater":"Second Number Greater";
		System.out.println("biFunction.apply(3, 5) : "+biFunction.apply(3, 5));
		
		/**
		 * BiFunction can take two arguments for processing
		 * Default function andThen() available
		 */
		BiConsumer<String, Integer> biConsumer = (s,i) -> System.out.println("Student Name : "+s+", Student Mark : "+i);
		biConsumer.accept("Rojan", 95);
		
		
		//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		BiFunction<String, Integer, Student> studBiFn = (n,r) -> new Student(n, r);
		System.out.println("studBiFn.apply(\"Rojan\", 95) : "+studBiFn.apply("Rojan", 95));
		
		BiFunction<Employee, TimeSheet, Double> salCalBiFn = (emp,tmsht) -> {
			return emp.getDailyWage()*tmsht.getNoOfWorkingDays();
		};
		System.out.println(salCalBiFn.apply(new Employee("ddd", 12, 3333), new TimeSheet("12", 22)));
		
	}
}
class Student {
	private String name;
	private Integer mark;

	/**
	 * @param name
	 * @param mark
	 */
	public Student(String name, Integer mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, mark=%s]", name, mark);
	}
	
}

class Employee{
	private String empName;
	private int empNo;
	private double dailyWage;
	/**
	 * @param empName
	 * @param empNo
	 * @param dailyWage
	 */
	public Employee(String empName, int empNo, double dailyWage) {
		super();
		this.empName = empName;
		this.empNo = empNo;
		this.dailyWage = dailyWage;
	}
	@Override
	public String toString() {
		return String.format("Employee [empName=%s, empNo=%s, dailyWage=%s]", empName, empNo, dailyWage);
	}
	public String getEmpName() {
		return empName;
	}
	public int getEmpNo() {
		return empNo;
	}
	public double getDailyWage() {
		return dailyWage;
	}
	
}

class TimeSheet{
	private String empNo;
	private int noOfWorkingDays;
	/**
	 * @param empNo
	 * @param noOfWorkingDays
	 */
	public TimeSheet(String empNo, int noOfWorkingDays) {
		super();
		this.empNo = empNo;
		this.noOfWorkingDays = noOfWorkingDays;
	}
	public String getEmpNo() {
		return empNo;
	}
	public int getNoOfWorkingDays() {
		return noOfWorkingDays;
	}
	@Override
	public String toString() {
		return String.format("TimeSheet [empNo=%s, noOfWorkingDays=%s]", empNo, noOfWorkingDays);
	}
	
}