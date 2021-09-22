package com.ss.wk1.review;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LambdasTest {

	Lambdas lambda = new Lambdas();
	@Test
	public void testOddNull() {
		assertEquals("NULL", lambda.isOdd().perform(null));
	}

	@Test
	public void testOddTrue() {
		assertEquals("ODD", lambda.isOdd().perform(3));
	}

	@Test
	public void testOddFalse() {
		assertEquals("EVEN", lambda.isOdd().perform(2));
		assertEquals("EVEN", lambda.isOdd().perform(0));
	}

	@Test
	public void testOddNegative() {
		assertEquals("EVEN", lambda.isOdd().perform(-2));
		assertEquals("ODD", lambda.isOdd().perform(-3));
	}

	@Test
	public void testPrimeNull() {
		assertEquals("NULL", lambda.isPrime().perform(null));
	}

	@Test
	public void testPrime() {
		assertEquals("PRIME", lambda.isPrime().perform(11));
	}

	@Test
	public void testNotPrime() {
		assertEquals("COMPOSITE", lambda.isPrime().perform(16));
	}

	@Test
	public void testNegativePrime() {
		assertEquals("COMPOSITE", lambda.isPrime().perform(-16));
		assertEquals("COMPOSITE", lambda.isPrime().perform(-11));

	}

	@Test
	public void testPrimeZero() {
		assertEquals("PRIME", lambda.isPrime().perform(0));
	}

	@Test
	public void testPalindromeNull() {
		assertEquals("NO", lambda.isPalindrome().perform(null));
	}

	@Test
	public void testPalindromeTrue() {
		assertEquals("PALINDROME", lambda.isPalindrome().perform(1));
		assertEquals("PALINDROME", lambda.isPalindrome().perform(111));
		assertEquals("PALINDROME", lambda.isPalindrome().perform(1111));
		assertEquals("PALINDROME", lambda.isPalindrome().perform(363));

	}

	@Test
	public void testPalindromeFalse() {
		assertEquals("NO", lambda.isPalindrome().perform(1234));
		assertEquals("NO", lambda.isPalindrome().perform(113));
		assertEquals("NO", lambda.isPalindrome().perform(1114));
	}

	@Test
	public void testPalindromeNegative() {
		assertEquals("NO", lambda.isPalindrome().perform(-1234));
		assertEquals("PALINDROME", lambda.isPalindrome().perform(-101));

	}

}
