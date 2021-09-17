package com.ss.hw4.script;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LineTest {
	Line line = new Line(0, 0, 2, 2);

	@Test
	public void TestNotEqualsSlope() {

		assertNotEquals(0, line.getSlope());
	}

	@Test
	public void TestEqualsSlope() {
		assertEquals(1.0, line.getSlope(), .0001);

	}

	@Test
	public void TestUndefinedSlope() {
		line = new Line(0, 0, 5, 0);

		assertEquals(0, line.getSlope(), .0001);

	}

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();

	@Test
	public void TestThrowsSlope() {
		line = new Line(1, 0, 1, 1);
		exceptionRule.expect(ArithmeticException.class);
		line.getSlope();

	}

	@Test
	public void TestNegativeSlope() {
		line = new Line(0, 4, 4, 0);
		assertEquals(-1, line.getSlope(), .0001);
		line = new Line(0, 0, 3, -6);
		assertEquals(-2, line.getSlope(), .0001);

	}

	@Test
	public void TestDifferentQuadrants() {
		line = new Line(-2, 4, 0, 0);
		assertEquals(-2, line.getSlope(), .0001);
		line = new Line(-2, -4, 0, 0);
		assertEquals(2, line.getSlope(), .0001);
		line = new Line(-2, -4, 0, 0);

	}

	@Test
	public void TestNotGetDistance() {
		assertNotEquals(16, line.getDistance());
	}

	@Test
	public void TestGetDistance() {
		line = new Line(0, 0, 3, 4);
		assertEquals(5, line.getDistance(), .0001);
		line = new Line(3, 4, 0, 0);
		assertEquals(5, line.getDistance(), .0001);
		line = new Line(3, 5, 2, 1);
		assertEquals(4.1231, line.getDistance(), .0001);

	}

	@Test
	public void TestZeroDistance() {
		line = new Line(0, 0, 0, 0);
		assertEquals(0, line.getDistance(), .0001);

	}

	@Test
	public void TestNotParallelTo() {
		Line line2 = new Line(0, 0, 1, 0);
		assertNotEquals(true, line.parallelTo(line2));

	}

	@Test
	public void TestParallelTo() {
		Line line2 = new Line(1, 1, 3, 3);
		assertEquals(true, line.parallelTo(line2));
		assertEquals(true, line2.parallelTo(line));
		line2 = new Line(1, 1, 10, 10);
		assertEquals(true, line.parallelTo(line2));
		assertEquals(true, line2.parallelTo(line));

	}

	@Test
	public void TestParallelToUndefined() {
		Line line2 = new Line(-1, 5, 4, 5);
		line = new Line(0, 0, 2, 0);
		assertEquals(true, line.parallelTo(line2));
		assertEquals(true, line2.parallelTo(line));

	}

}
