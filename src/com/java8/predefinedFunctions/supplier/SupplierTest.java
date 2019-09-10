package com.java8.predefinedFunctions.supplier;

import java.util.Date;
import java.util.Random;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		/**
		 * Without providing input provides output. Return type is important. Abstract
		 * method is get() : returns R type Eg: ResultSet values getting
		 * 
		 * Contains no default or static methods
		 */
		// Date supplier
		Supplier<Date> dateSupp = () -> new Date();
		System.out.println(dateSupp.get());

		// Random Name Generator
		Supplier<String> nameSupp = () -> {
			String[] strArr = { "adada", "etrzr", "hgjgjgj", "ziziz" };
			int x = (int) (Math.random() * 4);
			return strArr[x];
		};
		System.out.println(nameSupp.get());

		// Random Name Generator
		Supplier<Long> oTPSupp = () -> {		
			return (long) (Math.random() * 1000000);
		};
		for (int i = 0; i < 5; i++) {
			System.out.println(oTPSupp.get());
		}
		
		//Random Password passGen with Rules
		Supplier<String> passGen = ()->{
			Supplier<Integer> intVal= ()-> (int)(Math.random()*10);
			Supplier<Character> charValSup = () -> {
				String allowedCharValues = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@!?";
				return allowedCharValues.charAt((int) (Math.random()*29));
			};
			String pwd="";
			for (int j = 0; j < 8; j++) {
				if(j%2==0)
					pwd = pwd+intVal.get();
				else
					pwd = pwd+charValSup.get();
			}
			return pwd;
		};
		for (int i = 0; i < 5; i++) {
			System.out.println(passGen.get());
		}
	}
}
