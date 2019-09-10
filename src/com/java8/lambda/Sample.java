package com.java8.lambda;
/**
 * Predefined Functional Interface
 * Runnable, Callable
 * @author rojan
 *
 */
//class SampleRunnable implements Runnable {
//
//	@Override
//	public void run() {
//		for (int i = 0; i < 10; i++) {
//			System.out.println("child task "+i);
//		}
//	}
//	
//}
//
//public class Sample{
//	public static void main(String[] args) {
//		Runnable run = new SampleRunnable();
//		Thread t = new Thread(run);
//		t.start();
//		for (int i = 0; i < 20; i++) {
//			System.out.println("main task "+i);
//		}
//	}
//}

public class Sample{
	public static void main(String[] args) {
		
		//Lambda Implementation
		Runnable run = () -> {
			for (int i = 0; i < 10; i++) {
				System.out.println("child task run1 "+i);
			}
		};
		
		//Anonymous Inner Class Implementation
		Runnable run2 = new Runnable() {			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.out.println("child task run2 "+i);
				}
				
			}
		};
		
//		run.run();
		Thread t = new Thread(run);
		t.start();
		Thread t1 = new Thread(run2);
		t1.start();
		
		//Directly using Runnable interface -- Lambda
		Thread t3 = new Thread(()-> {
			for (int i = 0; i < 10; i++) {
				System.out.println("child task run3 "+i);
			}
		}); 
		t3.start();
		
		for (int i = 0; i < 20; i++) {
			System.out.println("main task "+i);
		}
	}
}