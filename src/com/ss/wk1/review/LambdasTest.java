package com.ss.wk1.review;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LambdasTest {

	// Lambdas lambda = new Lambdas();
	@Test
	public void testOddNull() {
		assertEquals("NULL", Lambdas.isOdd().perform(null));
	}

	@Test
	public void testOddTrue() {
		assertEquals("ODD", Lambdas.isOdd().perform(3));
	}

	@Test
	public void testOddFalse() {
		assertEquals("EVEN", Lambdas.isOdd().perform(2));
		assertEquals("EVEN", Lambdas.isOdd().perform(0));
	}

	@Test
	public void testOddNegative() {
		assertEquals("EVEN", Lambdas.isOdd().perform(-2));
		assertEquals("ODD", Lambdas.isOdd().perform(-3));
	}

	@Test
	public void testPrimeNull() {
		assertEquals("NULL", Lambdas.isPrime().perform(null));
	}

	@Test
	public void testPrime() {
		assertEquals("PRIME", Lambdas.isPrime().perform(11));
	}

	@Test
	public void testNotPrime() {
		assertEquals("COMPOSITE", Lambdas.isPrime().perform(16));
	}

	@Test
	public void testNegativePrime() {
		assertEquals("COMPOSITE", Lambdas.isPrime().perform(-16));
		assertEquals("COMPOSITE", Lambdas.isPrime().perform(-11));

	}

	@Test
	public void testPrimeZero() {
		assertEquals("PRIME", Lambdas.isPrime().perform(0));
	}

	@Test
	public void testPalindromeNull() {
		assertEquals("NO", Lambdas.isPalindrome().perform(null));
	}

	@Test
	public void testPalindromeTrue() {
		assertEquals("PALINDROME", Lambdas.isPalindrome().perform(1));
		assertEquals("PALINDROME", Lambdas.isPalindrome().perform(111));
		assertEquals("PALINDROME", Lambdas.isPalindrome().perform(1111));
		assertEquals("PALINDROME", Lambdas.isPalindrome().perform(363));

	}

	@Test
	public void testPalindromeFalse() {
		assertEquals("NO", Lambdas.isPalindrome().perform(1234));
		assertEquals("NO", Lambdas.isPalindrome().perform(113));
		assertEquals("NO", Lambdas.isPalindrome().perform(1114));
	}

	@Test
	public void testPalindromeNegative() {
		assertEquals("NO", Lambdas.isPalindrome().perform(-1234));
		assertEquals("PALINDROME", Lambdas.isPalindrome().perform(-101));

	}

}
