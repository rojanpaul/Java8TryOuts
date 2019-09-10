package com.java8.streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Basically used for processing collection objects
 * 
 * @author rojan
 *
 */
public class StreamsTest {
	public static void main(String[] args) {

		// Data
		ArrayList<Integer> array = new ArrayList<Integer>();
		array.add(5);
		array.add(10);
		array.add(0);
		array.add(25);
		array.add(20);
		array.add(15);

		// Util Java 1.7
		// Find Even numbers
		ArrayList<Integer> arry2 = new ArrayList<>();
		for (Integer i : array) {
			if (i % 2 == 0)
				arry2.add(i);
		}
		System.out.println(arry2);

		// With Streams -- from 1.8
		/***
		 * With Streams -- from 1.8 filter() Concept : To filter from original values
		 * Streams is a default method in Collection interface
		 * map() concept : to create new array by performing some operation on all
		 * elements
		 */
		// Find Even numbers
		List<Integer> array3 = array.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(array3);

		// Multiply all elements by 2//Util Java 1.7
		ArrayList<Integer> arry4 = new ArrayList<>();
		for (Integer i : array) {
			arry4.add(i * 2);
		}
		System.out.println(arry4);

		// Multiply all elements by 2
		List<Integer> array5 = array.stream().map(i -> i*2).collect(Collectors.toList());
		System.out.println(array5);
	}
}
