package com.java8.predefinedFunctions.predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Default method test() : boolean in Predicate
 * 
 * @author rojan
 *
 */
interface CheckPredicate{
	public void checkPredicteOfArray(int[] array, Predicate<Integer> predicate);
}
interface CheckPredicateStringArray{
	public void checkPredicte(String[] array, Predicate<String> predicate);
}
public class PredicateTest {

	public boolean test(Integer i) {
		if (i > 10)
			return true;
		else
			return false;
	} 
	
	

	public static void main(String[] args) {
//		Predicate<Integer> predicate = (i) -> i > 10 ? true : false;
		Predicate<Integer> predicate = (i) -> i > 10;
		System.out.println("predicate.test(7) : " + predicate.test(7));
		System.out.println("predicate.test(13) : " + predicate.test(13));
		
		PredicateTest pr = new PredicateTest();
		System.out.println("Normal valuation : " + pr.test(7));
		
		Predicate<String> predicateString = (s) -> s.length()>5;
		System.out.println("predicateString.test(\"hsgfjksdgfd\") : "+predicateString.test("hsgfjksdgfd"));
		System.out.println("predicateString.test(\"asda\") : "+predicateString.test("asda"));
		
		Predicate<Collection> predCollection = c -> c.isEmpty();
		System.out.println("predCollection new : "+predCollection.test(new ArrayList<String>()));
		ArrayList<String> array = new ArrayList<>();
		array.add("Test");
		System.out.println("predCollection new : "+predCollection.test(array));
		
		/**
		 * All values are zeros
		 */
//		Predicate Joining
//		negate() , and(), or() -- All these methods are default methods.
//		Also one static method : isEqual
				
		System.out.println("predicateString.test(\"asda\") : "+predicateString.negate().test("asda"));
		
		int[] inpArr = {1,2,3,7,10,14,15};
		Predicate<Integer> predGreater10 = i -> i>10;
		Predicate<Integer> predIsEven = i -> i%2 == 0;
		
		CheckPredicate cp = (inp,pred) -> {
			for(int i : inp) {
				if(pred.test(i)) {
					System.out.println(i);
				}
			}
		};
		System.out.println("predicate : predIsEven : ");
		cp.checkPredicteOfArray(inpArr, predIsEven);
		System.out.println("predicate : predGreater10 : ");
		cp.checkPredicteOfArray(inpArr, predGreater10);
		System.out.println("predicate Negate : predIsEven : ");
		cp.checkPredicteOfArray(inpArr, predIsEven.negate());
		System.out.println("predicate Negate : predGreater10 : ");
		cp.checkPredicteOfArray(inpArr, predGreater10.negate());
		System.out.println("predicate : predIsEven : predGreater10 ");
		cp.checkPredicteOfArray(inpArr, predIsEven.and(predGreater10));
		System.out.println("predicate : predIsEven : predGreater10 : negate");
		cp.checkPredicteOfArray(inpArr, predIsEven.and(predGreater10).negate());
		
		System.out.println("predicate : predIsEven : predGreater10 : or");
		cp.checkPredicteOfArray(inpArr, predIsEven.or(predGreater10));
		
		//********************************************************************************
		CheckPredicateStringArray checkPredicateStringArray = (s,p) -> {
			int count = 1;
			
			for(String string : s) {
				if(p.test(string)) {
					System.out.print(string+" "+count+++", ");
				}
			}
			System.out.println("predStartWithK Values : "+ (s.length - count));
		};
		
		Predicate<String> predicateIsNull = s -> s == null;
		Predicate<String> predicateIsEmpty = s -> s.isEmpty();
		Predicate<String> predStartWithK = s -> s.charAt(0) == 'K';
		
		String[] array1 = {"Karthik","sfsf",null,"Ksfsf","sasKsad","",null,""};
		checkPredicateStringArray.checkPredicte(array1, 
				predicateIsNull.negate().and(predicateIsEmpty.negate()).and(predStartWithK));
		//********************************************************************************
//		Predicate<User> checkPassPredicate = user -> 
//			user.userName.equals("rojan") && user.password.equals("java");
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter UserName :");
//		String userName = scanner.next();
//		System.out.println("Enter Password :");
//		String password = scanner.next();
//		User user = new User(userName, password);
//		if(checkPassPredicate.test(user)) {
//			System.out.println("Successfully logged in : Valid User");
//		}else {
//			System.out.println("Invalid User Alert. Please login again");
//		}
		
		//***********************************************************************************
		
		Predicate<SoftwareEngineer> softwareEngPredicate = s -> s.age>18 && s.hasGirlFriend;
		
		SoftwareEngineer[] softEngs = {new SoftwareEngineer("name", 19, true)};
		for(SoftwareEngineer eg : softEngs) {
			if(softwareEngPredicate.test(eg)) {
				System.out.println("Allowed : "+ eg);
			}
		}
		
		//*************************************************************************************
		
//		Predicate isEquals() method -- static method -- for equality check of an object
		Predicate<String> staticPredicate = Predicate.isEqual("ROJAN");
		System.out.println("staticPredicate : ROJAN "+staticPredicate.test("ROJAN"));
		System.out.println("staticPredicate : TESTER "+staticPredicate.test("TESTER"));
	}
	
}

class User{
	String userName;
	String password;
	/**
	 * @param userName
	 * @param password
	 */
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return String.format("User [userName=%s, password=%s]", userName, password);
	}
	
}

class SoftwareEngineer{
	String name;
	int age;
	boolean hasGirlFriend;
	/**
	 * @param name
	 * @param age
	 * @param hasGirlFriend
	 */
	public SoftwareEngineer(String name, int age, boolean hasGirlFriend) {
		super();
		this.name = name;
		this.age = age;
		this.hasGirlFriend = hasGirlFriend;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public boolean isHasGirlFriend() {
		return hasGirlFriend;
	}
	@Override
	public String toString() {
		return String.format("SoftwareEngineer [name=%s, age=%s, hasGirlFriend=%s]", name, age, hasGirlFriend);
	}
	
	
	
}
