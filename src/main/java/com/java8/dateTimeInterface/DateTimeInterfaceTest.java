package com.java8.dateTimeInterface;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DateTimeInterfaceTest {
	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		LocalTime lt = LocalTime.now();
		System.out.println(lt);
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println(ldt);
		
		LocalDateTime ldt2 = LocalDateTime.of(
				LocalDate.of(1990, 1, 31), LocalTime.of(9, 45));
		
		LocalDate ld2 = LocalDate.of(1990, 1, 31);
		
		Period p = Period.between(ld2,ld);
		System.out.println(p.getYears()*365 +p.getMonths()*30+p.getDays());
	}
}
