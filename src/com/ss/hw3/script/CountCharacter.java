/**
 * 
 */
package com.ss.hw3.script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Walter Chang
 * Searches a given file for the number of instances of a character
 * Character is the first character taken from a command line argument
 *
 */
public class CountCharacter {

	/**
	 * @param args: First character taken from command line used in search 
	 */
	public static void main(String[] args) {
		
		/* If no valid character is found then return */
		if(args.length ==0) {
			System.out.println("Please enter at least one character in the command line");
			return;
		}
		char charToSearch = args[0].charAt(0);
		/* Print out what character is being looked for */
		System.out.println("Searching for " +charToSearch);
		CountCharacter obj = new CountCharacter();
		/* Show the number of characters found */
		int sum = obj.countChar((int)args[0].charAt(0), "./randomText");
		System.out.println(sum);

		
	}
	/**
	 * @param args: int c -- the ascii value of character to look for
	 * 				String path -- the path of the file
	 * Return value: the number of characters c in the path's file or 0 of file is not found
	 */				
	public int countChar(int c, String path) {
		int num = 0;
		
		/* Automatically close buffered reader after try block */
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			int nextChar;
			/* Continuously read chars and compare ascii values*/
			while((nextChar = br.read()) != -1) {
			if(nextChar == c) num++;
			}
		} catch(IOException e) {
			System.out.println("File Not Found");
		}
		return num;
		
	}

}
