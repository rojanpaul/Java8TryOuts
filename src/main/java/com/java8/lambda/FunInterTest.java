package com.java8.lambda;

@FunctionalInterface
public interface FunInterTest {
	//SAM -- SIngle Abstract MEthod Interface are called functional Interface
	public void testmethod();
	
	default void myMethod(){
		
	}
	
	public static void myMethod2() {
		
	}
}
