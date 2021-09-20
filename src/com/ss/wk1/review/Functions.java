/**
 * 
 */
package com.ss.wk1.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Walter Chang Functions that implement various tasks. Correspond to
 *         Assignment 2, 3, 4, and 5
 */
public class Functions {

	/*
	 * Assignment 2: Functional Given a list of non-negative integers, return an
	 * integer list of the rightmost digits.
	 */
	public List<Integer> rightMostDigit(List<Integer> nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			/* If value is null substitute with 0 */
			if (nums.get(i) == null || nums.get(i) < 0) {
				res.add(0);
				continue;
			}

			// int sign = nums.get(i) < 0 ? -1 : 1;
			int num = Math.abs(nums.get(i));
			/* continue to divide number by 10 for N*Log2(N) runtime */
			while (num >= 10) {
				num /= 10;
			}
			// res.add(sign * num);
			res.add(num);
		}
		return res;
	}

	/*
	 * Assignment 4: Functional Given a list of strings, return a list where each
	 * string has all its "x" removed.
	 */
	public List<Integer> doubling(List<Integer> nums) {
		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) == null) {
				nums.set(i, 0);

				/* If overflow will occur, then set it to the max or min value */
			} else if (nums.get(i) > Integer.MAX_VALUE / 2) {
				nums.set(i, Integer.MAX_VALUE);
			} else if (nums.get(i) < Integer.MIN_VALUE / 2) {
				nums.set(i, Integer.MIN_VALUE);
			} else {
				nums.set(i, nums.get(i) * 2);
			}
		}
		return nums;

	}

	/*
	 * Assignment 4: Functional Given a list of strings, return a list where each
	 * string has all its "x" removed.
	 */
	public List<String> removeX(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == null) {
				list.set(i, "");
				continue;
			}
			String s = list.get(i);
			int x = s.indexOf("x");
			/* Use indexOf to make find the next instance of X. Sacrifices 
			 * speed for the use of Strings in permanent memory space.*/
			while (s.indexOf("x") != -1) {
				s = s.substring(0, x) + s.substring(x + 1, s.length());
				x = s.indexOf("x");
			}
			list.set(i, s);
		}
		return list;

	}

	/*
	 * Given an array of ints, is it possible to choose a group of some of the ints,
	 * such that the group sums to the given target
	 */
	public boolean groupSumClump(int[] nums, int sum, int i) {
		if (sum == 0) //If sum is zero, then we have found a permutation that fulfills the requirements
			return true;
		if (i >= nums.length)
			return false;
		int add = nums[i];
		/* add will contain all consecutive elements of the same number*/
		while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
			add += nums[i + 1];
			i++;
		}
		/* either add all the numbers of the same value or add none; increment i*/
		return groupSumClump(nums, sum - add, i + 1) || groupSumClump(nums, sum, i + 1);

	}

	

}
