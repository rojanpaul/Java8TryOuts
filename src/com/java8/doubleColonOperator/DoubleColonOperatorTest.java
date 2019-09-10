package com.java8.doubleColonOperator;

public class DoubleColonOperatorTest {

	public static void myMethod() {
		System.out.println("Hello Rojan. Welcome to method reference");
	}

	public static void main(String[] args) {
		/**
		 * Double Colon operator (::) Used for method reference and constructor
		 * reference Advantage : Code reusability
		 * 
		 * 1. A well defined method(static) in a class with same signature can be
		 * invoked by calling a Functional Interface method Return type or modifier not
		 * important
		 * 
		 * 2. If it is instance method, instance needs to be used instead of class name.
		 * 
		 * # Basically can be used instead of defining lambda function implementation
		 */
		// Static method reference
		Interf i = DoubleColonOperatorTest::myMethod;
		// Even though v r calling sample here it is internally referencing myMethod()
		i.sample();

		// Instance method reference
		MyClass myClass = new MyClass();
		Interf i2 = myClass::myTestMethod;
		i2.sample();
		// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		Runnable runnable = () -> {
			for (int j = 0; j < 10; j++) {
				System.out.println("child : " + j);
			}
		};
		Thread thread = new Thread(runnable);
		thread.start();
		for (int j = 0; j < 10; j++) {
			System.out.println("main : " + j);
		}
		
		Runnable runnable2 = myClass::myTestMethod;
		Thread thread2 = new Thread(runnable2);
		thread2.start();
		
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		
		/**
		 * Constructor Reference
		 * 
		 */
		Interf2 interf2 = MyClass::new;
		MyClass myClass1 = interf2.sample2();
		
		Interf interf = MyClass::new;
		interf.sample();//Cannot recieve object. But constructor will be invoked and object will be created
	}

}

interface Interf {
	public void sample();
}

interface Interf2 {
	public MyClass sample2();
}


class MyClass {
	
	public MyClass() {
		System.out.println("Inside MyClass Constructor");
	}
	
	public void myTestMethod() {
		System.out.println("Inside my Test Method of Instance");
		for (int j = 0; j < 10; j++) {
			System.out.println("myTestMethod : " + j);
		}
	}
}