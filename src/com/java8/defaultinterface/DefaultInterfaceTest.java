package com.java8.defaultinterface;

/**
 * Default Method vs Abstract
 * 
 * @author rojan
 *
 */
public class DefaultInterfaceTest {
/**
 * Interface till Java 7 can have only abstract methods and public static variables
 * Interface in Java 1.8 we have deafult methods which are concrete.
 */
	public static void main(String[] args) {
		DefaultTest defaultTest = new DefaultTestImpl();
		defaultTest.m1();
		defaultTest.m2();
		defaultTest.m3();
	}
}

interface DefaultTest{
	public void m1();
	default void m2() {
		System.out.println("Executing Original m2");
	}
	
	default void m3() {
		System.out.println("Executing original m3");
	}
}

class DefaultTestImpl implements DefaultTest{

	@Override
	public void m1() {
		// Overriding normal absstract methods
		System.out.println("Inside implemted method m1");
	}
	
	@Override
	public void m3() {
		// Overriding normal absstract methods
		System.out.println("Inside implemted method m3");
	}
	
}