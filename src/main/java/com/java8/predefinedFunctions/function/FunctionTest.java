package com.java8.predefinedFunctions.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionTest {
	public static void main(String[] args) {
		/**
		 * Function : method predefined function method is f1.apply():
		 * Function chaining : Two ways : 1. f1.andThen(f2) 2. f1.compose(f2);
		 */
		// Simple function to find length
		Function<String, Integer> func = s -> s.length();
		System.out.println(func.apply("jsbdkjsbfs"));

		Function<Integer, Integer> intFn = i -> i * i;
		System.out.println(intFn.apply(12));

		Function<String, String> strFn = s -> s.replaceAll(" ", "");
		System.out.println(strFn.apply("My Name is Khan"));

		Function<String, Integer> countSpac = s -> {
			int originalLength = s.length();
			System.out.println(s);
			return originalLength - s.replaceAll(" ", "").length();

		};
		System.out.println(countSpac.apply("My Name is Khan"));

		// Fn to find Grade of students
		Function<Student, String> studFn = s -> s.getMark() >= 80 ? "A - Distinction"
				: s.getMark() >= 60 ? "B - First Class"
						: s.getMark() >= 50 ? "C - Second Class" : s.getMark() >= 35 ? "D - Third CLass" : "E : Failed";
		List<Student> studList = new ArrayList<Student>();
		studList.add(new Student("", 81));
		studList.add(new Student("", 71));
		studList.add(new Student("", 61));
		studList.add(new Student("", 51));
		studList.add(new Student("", 41));
		studList.add(new Student("", 31));
		studList.add(new Student("", 21));
		studList.add(new Student("", 35));
		for (Student s : studList) {
			System.out.println("Student Grade : " + studFn.apply(s));
		}

		// Fn to find total marks of students.
		Function<List<Student>, Integer> funMark = students -> {
			Integer sum = 0;
			for (Student s : students) {
				sum = sum + s.getMark();
			}
			return sum;
		};
		System.out.println("Total Mark of students : " + funMark.apply(studList));

		// Normalising grace mark of low performing students by 7
		Function<List<Student>, List<Student>> funNormalise = students -> {
			return students.stream().filter(s -> s.getMark() < 50)
					.map(s->{
						s.setMark(s.getMark()+7);
						return s;
					}).collect(Collectors.toList());
		};
		System.out.println(funNormalise.apply(studList));
		
		/**
		 * Function chaining
		 */
//		Function<String, Integer> func = s -> s.length();
//		System.out.println(func.apply("jsbdkjsbfs"));
//
//		Function<Integer, Integer> intFn = i -> i * i;
//		System.out.println(intFn.apply(12));
//
//		Function<String, String> strFn = s -> s.replaceAll(" ", "");
//		System.out.println(strFn.apply("My Name is Khan"));
		
		//Combing two functions together
		System.out.println("Combing two functions together using .andThen : "+strFn.andThen(func).apply("My Name is Khan"));
		System.out.println("Combing two functions together using .compose() : "+func.compose(strFn).apply("My Name is Khan"));
		
		Function<Integer, Integer> cubeFunction = i -> i*i*i;
		Function<Integer, Integer> doublingFunction = i -> i*2;
		System.out.println("cubeFunction.andThen(doublingFunction).apply(4) : "+cubeFunction.andThen(doublingFunction).apply(4));
		System.out.println("cubeFunction.compose(doublingFunction).apply(4) : "+cubeFunction.compose(doublingFunction).apply(4));
		
		/**
		 * Identity Function
		 */
		Function<String, String> identityFn = Function.identity();
		System.out.println("identityFn.apply(\"Rojan\") : "+identityFn.apply("Rojan"));
		
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
