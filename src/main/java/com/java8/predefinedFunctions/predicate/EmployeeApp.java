package com.java8.predefinedFunctions.predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeApp {
	public static void main(String[] args) {
		ArrayList<Employee> empList = new ArrayList<>();
		empList.add(new Employee("qwer", "Reseter", 23244l, "ASdf"));
		Predicate<Employee> predEmp= emp -> emp.getSalary()>20000;
	}
}
class Employee{
	private String name;
	private String designation;
	private Long salary;
	private String city;
	/**
	 * @param name
	 * @param designation
	 * @param salary
	 * @param city
	 */
	public Employee(String name, String designation, Long salary, String city) {
		super();
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return String.format("Employee [name=%s, designation=%s, salary=%s, city=%s]", name, designation, salary, city);
	}
	
}