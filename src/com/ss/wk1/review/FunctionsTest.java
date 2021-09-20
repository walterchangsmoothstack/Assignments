package com.ss.wk1.review;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FunctionsTest {
	Functions function = new Functions();
	List<Integer> list = Arrays.asList(20, 30, 41, 3, 842, 1245, null, 9999);
	List<Integer> compare = Arrays.asList(2, 3, 4, 3, 8, 1, 0, 9);
	List<String> strings = Arrays.asList("axe", "xxxx", "bfsadlkfjx", null, "asx-men","");

	@Test
	public void testRightMost() {
		compare = Arrays.asList(2, 3, 4, 3, 8, 1, 0, 9);
		assertEquals(compare, function.rightMostDigit(list));
	}
	@Test
	public void testRightMostNegative() {
		list = Arrays.asList(-20, -1245, null, -9999, 4);
		compare = Arrays.asList(0, 0, 0, 0, 4);
		assertEquals(compare, function.rightMostDigit(list));
	}
	@Test
	public void testDoubling() {
		list = Arrays.asList(-20, 40, null, 1000);
		compare = Arrays.asList(-40, 80, 0, 2000);
		assertEquals(compare, function.doubling(list));
	}
	@Test
	public void testDoublingOverflow() {
		list = Arrays.asList(1073741824, -1073741824);
		compare = Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE);
		assertEquals(compare, function.doubling(list));
	}
	@Test
	public void testNullRemoveX() {
		assertEquals(new ArrayList<>(), function.removeX(new ArrayList<>()));
	}
	@Test
	public void testRemoveX() {
		List<String> ans = Arrays.asList("ae", "", "bfsadlkfj", "" , "as-men","");
		assertEquals( ans ,function.removeX(strings));
	}
	
	@Test
	public void testGroupSumTrue() {	
		assertEquals(true, function.groupSumClump(new int[] {2, 4, 8}, 10,0));
		assertEquals(true, function.groupSumClump(new int[] {1, 2, 4, 8, 1}, 14, 0));
	}
	@Test
	public void testGroupSumFalse() {	
		assertEquals(false, function.groupSumClump(new int[] {1, 2, 2, 2, 5, 2}, 10, 0));
		assertEquals(false, function.groupSumClump(new int[] {2, 4, 4, 8}, 14, 0));
	}
	@Test
	public void testGroupSumGroup() {	
		assertEquals(false, function.groupSumClump(new int[] {2, 2, 2, 2, 2}, 8, 0));
		assertEquals(true, function.groupSumClump(new int[] {2, 2, 2, 2, 2, 5, 5}, 10, 0));

	}
	
	
}
