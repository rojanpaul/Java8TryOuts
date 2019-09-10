package com.java8.lambda;

public class LambdaBasic {
	/**
	 * Lambda expression is basically method definition/implemenatation of SAM.
	 * Calling is different.
	 * @param args
	 */
	
	public static void main(String[] args) {
//		(a,b) -> a+b;
		ChildFuncInterface childFuncInterface = () -> System.out.println("This is testing");
		childFuncInterface.testmethod();
		
		ChildFuncInterface2 childFuncInterface2 = (a,b) -> System.out.println("Sum : "+(a+b));
		childFuncInterface2.test(10, 20);
		
		ChildFuncInterface3 childFuncInterface3 = s -> s.length();
		int length = childFuncInterface3.test("sdbjsbbsns");
		System.out.println(" Length of String : "+length);
	}
}
