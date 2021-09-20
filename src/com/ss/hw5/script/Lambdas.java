/**
 * 
 */
package com.ss.hw5.script;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Walter Chang
 * Contains methods that sort or filter lists of Strings and integers with
 * use of lambda functions and comparators.
 */
public class Lambdas {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* 1) BASIC LAMBDAS. MAKE AN ARRAY CONTAINING A FEW STRINGS AND SORT*/
		List<String> directors = Arrays.asList("Spielberg", "Tarantino", "Scorsese", "Nolan", "Anderson", "Verhoeven",
				"Scott", "Wachowski", "Ebert", "Eastwood", null);
		/* Comparator for sorting shortest to longest */
		Comparator<String> shortToLong = (a, b)->{
				/* Check for null*/
				if (a == null)
					return 1;
				if (b == null)
					return -1;
				return a.length() - b.length();
			};
			
		System.out.println("\nSorted shortest to longest \n");
		sortList(directors, shortToLong);
		/* Comparator for sorting longest to shortest */
		Comparator<String> longToShort = (a,b) -> {
				/* Check for null*/
				if (a == null)
					return 1;
				if (b == null)
					return -1;
				return b.length() - a.length();
		};
		System.out.println("\nSorted longest to shortest \n");
		sortList(directors, longToShort);
		/* Comparator for sorting based off of first letter */
		Comparator<String> firstLetter = (a, b)-> {
				/* Edge case for null or 0 length strings*/
				if (a == null || a.length() == 0)
					return 1;
				if (b == null || b.length() == 0)
					return -1;
				return a.charAt(0) - b.charAt(0);
		};
		System.out.println("\nSorted by first letter \n");
		sortList(directors, firstLetter);
		/* Comparator that gives priority to strings starting with e */
		Comparator startWithE = new Comparator<String>() {
			public int compare(String a, String b) {
				/* Edge case for null or 0 length strings*/
				if (a == null || a.length() == 0)
					return 1;
				if (b == null || b.length() == 0)
					return -1;
				return Character.toUpperCase(a.charAt(0)) == 'E' ? -1
						: Character.toUpperCase(b.charAt(0)) == 'E' ? 1 : 0;
			}
		};
		System.out.println("\nSorted first if starts with E \n");
		sortList(directors, startWithE);

		/* RE-DO using static helper method */
		/*
		 * directors.stream().sorted( new Comparator<String>(){ public int
		 * compare(String a, String b) { if(a == null) return 1; if(b == null) return
		 * -1; return a.length() - b.length(); } }).forEach( d ->
		 * System.out.println(d));
		 * 
		 * System.out.println("\nDirectors from longest length to shortest \n");
		 * directors.stream().sorted( new Comparator<String>(){ public int
		 * compare(String a, String b) { if(a == null) return 1; if(b == null) return
		 * -1; return b.length() - a.length(); } }).forEach( d ->
		 * System.out.println(d));
		 * System.out.println("\nDirectors sorted by first letter \n");
		 * directors.stream().sorted( new Comparator<String>(){ public int
		 * compare(String a, String b) { if(a == null || a.length() == 0) return 1; if(b
		 * == null || b.length() == 0) return -1; return a.charAt(0) - b.charAt(0);
		 * 
		 * } }).forEach( d -> System.out.println(d));
		 * 
		 * Collections.sort(directors, new Comparator<String>() { public int
		 * compare(String a, String b) { if(a == null || a.length() == 0) return 1; if(b
		 * == null || b.length() == 0) return -1; return
		 * Character.toUpperCase(a.charAt(0)) == 'E' ? -1 :
		 * Character.toUpperCase(b.charAt(0)) == 'E'? 1 :0; }
		 * 
		 * }); directors.stream().forEach(d -> System.out.println(d));
		 */
		
		
		/* 2) JAVA 8 FEATURES */
		/*  WRITE A METHOD THAT RETURNS A CSV STRING BASED ON A GIVEN LIST OF INTEGERS*/
		List<Integer> list = new ArrayList<>();
		for(int i =0; i<100; i++) {
			list.add((int)Math.floor(Math.random()*100));
		}
		String s = commaSeparateList(list);
		System.out.println(s);
		
		
		
		/* 3)  MORE JAVA STREAMS PRACTICE */
		/* GIVEN A LIST OF STRINGS, WRITE A METHOD THAT RETURNS A LIST OF ALL STRINGS THAT
		 * FIT A SPECIFIC PATTERN*/
		List<String> aList = Arrays.asList("abc", "abcde", "jkl", "a';", ";']", null, "papaya");
		getSpecificString(aList).stream().forEach(a -> System.out.println(a));

	}
	/* helper method that takes in a list of strings and a comparator object. sorts
	 * based off of the comparator*/
	public static void sortList(List<String> list, Comparator<String> comp) {
		Collections.sort(list, comp);
		list.stream().forEach(d -> System.out.println(d));
	}
	
	/* 2) JAVA 8 FEATURES */
	/*  WRITE A METHOD THAT RETURNS A CSV STRING BASED ON A GIVEN LIST OF INTEGERS*/
	public static String commaSeparateList(List<Integer> list) {
		/* map each value to a String with e or o concatenated and join with comma */
		try {
		return list.stream().map(i -> {
			if(i % 2 == 0) {
				return "e" + i.toString();
			}
			else {
				return "o" + i.toString();
			}
		}).collect(Collectors.joining(","));
		}catch(NullPointerException e) {
			return "";
		}

	}
	
	/* 3) JAVA STREAMS PRACTICE*/
	/* FILTER A LIST TO STRINGS THAT START WITH "a" AND HAVE LENGTH 3*/
	public static List<String> getSpecificString(List<String> list) {
		
		return list.stream().filter(s -> {
			return s!= null && s.length() == 3 && s.charAt(0) == 'a';
		}).collect(Collectors.toList());
		
	}

}
