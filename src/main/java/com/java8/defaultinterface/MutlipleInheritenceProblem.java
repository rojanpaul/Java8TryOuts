package com.java8.defaultinterface;

/**
 * Abstract vs Default Interface
 * --------------------------------------------------
 * INterface :
 * All varibale shave to be public static final
 * Constructor 
 * Can refer lambda expressions
 * Do not talk about state of object
 * --------------------------------------------------
 * Abstract :
 * All varibale can be anything static or instance
 * Can have contructor, Instance creation
 * Cannot refer lambda expressions
 * 
 * Constructor
 * @author rojan
 *
 */
public class MutlipleInheritenceProblem {
	public static void main(String[] args) {
		Test test = new Test();
		test.m1();
		test.m2();
		Left.m3();
		//So overriding concept not applicable as i tis not available for implemntation class
		test.m3(); //-- Not available to implemnataion class. Can only be called by Interface name
	}
}

interface Left{
	
	default void m1() {
		System.out.println("Inside Left m1 method");
	}
	
	public void m2();
	
	public static void m3() {
		System.out.println("Inside general Utility methods");
	}
	//main method can be defined here
	public static void main(String[] args) {
		Left.m3();
	}
}

interface Right{
	default void m1() {
		System.out.println("Inside Right m1 method");
	}
}

class Test implements Left,Right{
	
	@Override
	public void m1() {
		/***
		 * Abiguity scenario resolving
		 */
		//Choose the method if no chnages
		Left.super.m1();
		//Else remove above line and implement your own
		System.out.println("My own implementation");
		
		Right.super.m1();
	}

	@Override
	public void m2() {
		System.out.println("Inside Test m2 method");
		
	}
	
	public void m3() {
		System.out.println("Not overriding.. Jusrt another method");
	}
	
}