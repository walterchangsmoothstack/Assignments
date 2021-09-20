package com.ss.hw5.script;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class DateTimeAPITest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	LocalDate date = LocalDate.of(2021, 9, 17);
	DateTimeAPI obj = new DateTimeAPI();

	@Test
	public void testPrevThursday() {
		LocalDate thurs = LocalDate.of(2021, 9, 16);
		assertEquals(thurs, obj.findPreviousThursday(date));
		assertNotEquals(date, obj.findPreviousThursday(thurs));
		thurs = LocalDate.of(2021, 9, 20);
		assertEquals(obj.findPreviousThursday(date), obj.findPreviousThursday(thurs));
	}

	@Test
	public void testPrevThursdayNull() {
		assertEquals(null, obj.findPreviousThursday(null));
	}

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void testDaysInMontsh() {
		obj.daysInMonths(date);
		String days ="312831303130313130313031";
		assertEquals(days, outContent.toString());
	}
	
	@Test
	public void TestNumMondays() {
		assertEquals(4, obj.numMondaysInMonth(date));
		
	}
	@Test
	public void testFridaythe13th() {
		assertEquals(true, obj.isItFridaythe13th(LocalDate.of(2020, Month.NOVEMBER, 13)));
		assertEquals(false, obj.isItFridaythe13th(date));
		assertEquals(false, obj.isItFridaythe13th(null));


	}

}
