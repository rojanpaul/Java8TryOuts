package com.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {
	public static void main(String[] args) {
		ArrayList<String> stringArray = new ArrayList<>();
		stringArray.add("hjsfjsjf");
		stringArray.add("fdsdg");
		stringArray.add("sggdfh");
		stringArray.add("arqtetzeze");
		stringArray.add("agdgdhgdh");
		stringArray.add("xasfddg");
		stringArray.add("xvdvdsd");
		System.out.println(stringArray);

		// Data
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		integerArray.add(5);
		integerArray.add(10);
		integerArray.add(0);
		integerArray.add(25);
		integerArray.add(20);
		integerArray.add(15);

		/**
		 * Streams configuring methods : filter() and map()
		 */
		// longer than 7
		List<String> stringList = stringArray.stream().filter(s -> s.length() >= 7).collect(Collectors.toList());
		System.out.println(stringList);
		// to Uppercase
		List<String> stringList1 = stringArray.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(stringList1);

		/**
		 * Stream processing methods : collect(), count(), sorted() & sorted(Comparator),
		 *  min(Comparator) & max(Comparator), forEach(), toArray()
		 */

		// To lnow size -- count() -- stream processing method
		long count = stringArray.stream().filter(s -> s.length() >= 7).count();
		System.out.println("Names longer than 7 : " + count);

		// Sorted() -- for sorting-- default sorting -- for customised sorting used
		// Comparator
		List<Integer> intList1 = integerArray.stream().sorted().collect(Collectors.toList());
		System.out.println("Natural sorting : " + intList1);
		List<Integer> intList2 = integerArray.stream().sorted((i1,i2)->i1>i2?-1:i1<i2?1:0).collect(Collectors.toList());
		System.out.println("Comparator sorting : " + intList2);
		List<Integer> intList3 = integerArray.stream().sorted((i1,i2)-> -i1.compareTo(i2)).collect(Collectors.toList());
		System.out.println("Comparator sorting using compareTo : " + intList3);
		
		//Min & Max
		Integer minValue = integerArray.stream().min((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Comparator sorting using compareTo : " + minValue);
		Integer maxValue = integerArray.stream().max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("Comparator sorting using compareTo : " + maxValue);
		
		//forEach()
	    stringArray.stream().forEach(s-> System.out.println(" ,"+s));
	    stringArray.stream().forEach(System.out::println);
	    
	    //toArray()
	    Integer[] intList4 = integerArray.stream().toArray(Integer[] :: new);
		System.out.println("Comparator sorting using compareTo : " + intList4);
		for(Integer i:intList4) {
			System.out.print(i);
		}
		
		/**
		 * Stream.of method -- to apply filtering to group of similar objects
		 * Double Array, or number array which is not a collection
		 */
		Stream<Integer> streamInt = Stream.of(9,99,999,9999,99999);
//		Long countStr = streamInt.count();
		System.out.println("");
//		System.out.println("Count : "+countStr);
//		streamInt.forEach(System.out::println);
		Integer max = streamInt.max((i1,i2)->i1.compareTo(i2)).get();
		System.out.println("max : "+max);
		
		Double[] d = {10.0,10.1,10.2,10.3,10.4,10.5,10.6};
		Stream<Double> strDouble = Stream.of(d);
		strDouble.forEach(System.out::println);
	}
}
