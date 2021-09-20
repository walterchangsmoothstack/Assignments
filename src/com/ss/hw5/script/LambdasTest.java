package com.ss.hw5.script;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;

public class LambdasTest {
	Lambdas lambda = new Lambdas();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	List<String> list = Arrays.asList("a", "e", "abc","ebc");
	List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
	@Test
	public void testSortList() {
		Comparator shortToLong = new Comparator<String>() {
			public int compare(String a, String b) {
				/* Check for null*/
				if (a == null)
					return 1;
				if (b == null)
					return -1;
				return a.length() - b.length();
			}

		};
		lambda.sortList(list, shortToLong);
		List<String> sorted = Arrays.asList("a", "e", "abc","ebc");
		assertEquals(sorted,list);
	}
	
	@Test
	public void testCommaSeparate() {
		String commaSeparated = "o1,e2,o3,e4,o5";
		assertEquals(commaSeparated, lambda.commaSeparateList(nums));
		nums.set(0, -1);
		commaSeparated = "o-1,e2,o3,e4,o5";
		assertEquals(commaSeparated, lambda.commaSeparateList(nums));
		nums.set(0, null);
		assertEquals("", lambda.commaSeparateList(nums));
	}
	
	@Test
	public void testSpecificString() {
		List<String> sorted = Arrays.asList("abc");
		assertEquals(sorted, lambda.getSpecificString(list));
		list.set(0, null);
		assertEquals(sorted, lambda.getSpecificString(list));

		
	}
}
