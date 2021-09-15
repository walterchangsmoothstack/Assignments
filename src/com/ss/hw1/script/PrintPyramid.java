/**
 * 
 */
package com.ss.hw1.script;

/**
 * @author Walter Chang
 * Prints a specific pattern
 *
 */
public class PrintPyramid {

	/**
	 * @param args NONE
	 */
	public static void main(String[] args) {
		/* Create two shapes to re-use using the reverse() function*/
		StringBuilder pyramid = new StringBuilder();
		StringBuilder rightHalf = new StringBuilder();
		String dots = ""; //create dots variable for dots
		int number = 1; //printing numbers
		int length = 0; //length of pyramid center
		int mid = 5; //pyramid center
		/* Create half of the triangle */
		for(int i =1; i<=4; i++) {
			for(int j = 0; j<i; j++) {
				rightHalf.append("*");
			}
			rightHalf.append("\n");
		}
		for(int i =0; i<9; i++) {
			dots +=".";
		}
		/* Create the pyramid */
		for(int i =0; i<4; i++) {
			for(int j =0; j<11; j++) {
				if(j>= mid-length && j<=length+mid) {
					pyramid.append("*");
				}
				else {
				pyramid.append(" ");
				}
			}
			pyramid.append("\n");
			length++;
		}
		/* Print out the pattern specified */
		System.out.println((number++)+")");
		System.out.print(rightHalf);
		System.out.println(dots);
		dots+= ".";
		System.out.println((number++)+")");
		System.out.print(dots);
		dots+= ".";
		System.out.println(rightHalf.reverse());
		System.out.println((number++)+")");
		System.out.print(pyramid);
		System.out.println(dots);
		dots+= ".";
		System.out.println((number++)+")");
		System.out.print(dots);
		System.out.println(pyramid.reverse());


		
		
	}

}
