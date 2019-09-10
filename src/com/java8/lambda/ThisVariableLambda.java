package com.java8.lambda;

interface Interf{
	public void m1();
}

class Test{
	int z =12;// from lambda expression enclosing instance variable can be accessed directly
	
	public void m2() {
		int y= 7; // All the varibales referenced inside lambda expression are treated as final. Or freezed for the portion of code
		
		Interf interf = () -> {
			int x=8;
			z=34;//The below rule not applicable for instance variable
//			y=9; All method local varibales referenced inside lambda expression are treated as final. Or freezed for the portion of code
			System.out.println("x : "+x);
			System.out.println("y : "+y);
			System.out.println("z : "+z);
		};
		interf.m1();
	}
}
public class ThisVariableLambda {
	public static void main(String[] args) {
		Test test = new Test();
		test.m2();
	}
}
