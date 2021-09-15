/**
 * 
 */
package com.ss.hw1.script;
import java.util.*;
/**
 * @author Walter Chang
 * Generates a number between 1-100 inclusive and allows the user 5 guesses.
 * If the user guesses within 10 numbers of the answer, the system will exit.
 *
 */
public class GuessNumber {

	/**
	 * @param args NONE
	 */
	final int MARGIN = 10;
	public static void main(String[] args) {
		int numTries = 5;
		/* Generate a number between 1 and 100 inclusive */
		int answer = (int)Math.floor(Math.random()*100)+1;
		Scanner scan = new Scanner(System.in);
		for(int i =0; i<numTries; i++) {
			String guess = scan.nextLine();
			/* Prevent runtime exception from non-integer input*/
			try {
				
				/* The user has guessed within the margin. Close scanner and exit */
				if(Math.abs(Integer.valueOf(guess)-answer) <= 10) {
					System.out.println("Congrats, the number was "+ answer);
					scan.close();
					return;
				}
			} catch(NumberFormatException e) {
				
			}
		}
		/* The user has guessed the maximum number of times */
		System.out.println("Sorry " + answer);
		scan.close();
	}

}
