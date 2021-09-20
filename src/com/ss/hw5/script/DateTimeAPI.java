/**
 * 
 */
package com.ss.hw5.script;

import java.io.ByteArrayOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Instant;

/**
 * @author Walter Chang
 * Refer to Date&Time.text for answer to the questions
 * Examples of code are provided in this file
 */
public class DateTimeAPI {

	/**
	 * @param args
	 */

	/* Returns the date of the previous thursday to input date */
	public LocalDate findPreviousThursday(LocalDate date) {
		if (date == null)
			return date;
		int days = (date.getDayOfWeek().getValue() + 3) % 7;
		return date.minusDays((days == 0) ? 7 : days);
	}

	/* Returns the number of days per month in year */
	public void daysInMonths(LocalDate date) {
		if (date == null)
			return;
		for (int m = 1; m <= 12; m++) {
			date = date.withMonth(m);
			System.out.print(date.withMonth(m).lengthOfMonth());
		}
	}

	/* Returns the number of mondays in the month of the date */
	public int numMondaysInMonth(LocalDate date) {
		if (date == null)
			return -1;
		int count = 0;
		for (int d = 1; d <= date.lengthOfMonth(); d++) {
			if (date.withDayOfMonth(d).getDayOfWeek().getValue() == 1)
				count++;
		}
		return count;
	}

	/* Returns if the day is friday the 13th */
	public boolean isItFridaythe13th(LocalDate date) {
		if (date == null)
			return false;
		return (date.getDayOfMonth() == 13 && date.getDayOfWeek().getValue() == 5);
	}

	public static void main(String[] args) {
		//Refer to Test Class for implementation examples
	}

}
