package com.ss.wk1.review;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @author Walter Chang Create a function interface PerformOperation and several
 *         methods that use the interface to return a lambda expression.
 */
public class Lambdas {

	interface PerformOperation {

		String perform(Integer i);
	}

	public PerformOperation isOdd() {
		/* Check if mod by 2 is 1 or 0 */
		return (i) -> (i == null) ? "NULL" : (Math.abs(i % 2) == 1) ? "ODD" : "EVEN";
	};

	/*
	 * Create an intstream from 2 to square root of number. If any int is divisible
	 * by the number, then it is composite. No need to loop past square root of
	 * number because the maximum quotient will be the square root of number
	 */
	public PerformOperation isPrime() {
		/*
		 * According to Google all negative numbers and zero in some definitions are
		 * considered composite
		 */
		return (i) -> (i == null) ? "NULL"
				: (i < 0 || i == 1) ? "COMPOSITE"
						: IntStream.range(2, (int) Math.sqrt(i) + 1).filter(a -> i % a == 0).findFirst().isPresent()
								? "COMPOSITE"
								: "PRIME";
	};

	public PerformOperation isPalindrome() {
		return (num) -> {
			if (num == null)
				return "NO";
			/* Use two counters to compare if the mirrored characters are the same or not */
			String value = num.toString();
			int i = num < 0 ? 1 : 0;
			int j = value.length() - 1;
			while (i < j) {
				if (value.charAt(i) != value.charAt(j))
					return "NO";
				i++;
				j--;
			}
			return "PALINDROME";
		};
	};

}
