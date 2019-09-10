package com.java8.predefinedFunctions.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerTest {
	public static void main(String[] args) {
		/**
		 * Consumer : predefined function
		 *  accept() method is the Fn Interface
		 *  Just consume the value provided, no return type
		 *  Contains only one default method andThen()
		 *  
		 *  Can be used for execute queries
		 */
		Consumer<String> consumer = s->System.out.println(s);
		consumer.accept("Print this consumer");
		
		List<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("lala", "comic", "MAL"));
		list.add(new Movie("lasfsfla", "action", "TAMIL"));
		list.add(new Movie("sfsf", "comic", "HINDI"));
		Consumer<Movie> cMovie = m -> {
			System.out.println("----------------------------------");
			System.out.println(m.getName());	
			System.out.println(m.getGeneric());	
			System.out.println(m.getLanguage());	
			System.out.println("----------------------------------");
		};
		
		for(Movie m: list) {
			cMovie.accept(m);
		}
		
		List<Student> studList = new ArrayList<Student>();
		studList.add(new Student("ss", 81));
		studList.add(new Student("faf", 71));
		studList.add(new Student("dfd", 61));
		studList.add(new Student("fadf", 51));
		studList.add(new Student("dfa", 41));
		studList.add(new Student("dfa", 31));
		studList.add(new Student("dd", 21));
		studList.add(new Student("afdf", 35));
		Predicate<Student> studPred = s -> s.getMark()<50;
		Function<Student, Student> studFn = s -> {
				s.setMark(s.getMark()+25);
				return s;
		};
		Consumer<Student> consStud = s -> {
			System.out.println("----------------------------------");
			System.out.println(s.getName());
			System.out.println(s.getMark());
			System.out.println("----------------------------------");
		};
		for(Student s:studList) {
			if(studPred.test(s)) {
				studFn.apply(s);
				consStud.accept(s);
			}
		}
		
		/***
		 * Consumer chaining
		 */
		Consumer<Movie> cName= m -> System.out.println(m.getName());
		Consumer<Movie> cGeneric= m -> System.out.println(m.getGeneric());
		Consumer<Movie> cLanguage= m -> System.out.println(m.getLanguage());
		cName.andThen(cGeneric).andThen(cLanguage).accept(new Movie("lala", "comic", "MAL"));
		cName.andThen(cGeneric.andThen(cLanguage)).accept(new Movie("lala", "comic", "MAL"));
		
	}
}
class Student {
	private String name;
	private Integer mark;

	/**
	 * @param name
	 * @param mark
	 */
	public Student(String name, Integer mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, mark=%s]", name, mark);
	}
	
}

class Movie{
	private String name;
	private String generic;
	private String language;
	
	/**
	 * @param name
	 * @param generic
	 * @param language
	 */
	public Movie(String name, String generic, String language) {
		super();
		this.name = name;
		this.generic = generic;
		this.language = language;
	}
	
	@Override
	public String toString() {
		return String.format("Movie [name=%s, generic=%s, language=%s]", name, generic, language);
	}

	public String getName() {
		return name;
	}
	public String getGeneric() {
		return generic;
	}
	public String getLanguage() {
		return language;
	}
	
}