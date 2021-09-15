/**
 * 
 */
package com.ss.hw2.script;

import java.util.Arrays;

/**
 * @author Walter Chang
 * Contains findMax method and an example using a 2D matrix initialized
 *
 */
public class Matrix2D {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Create custom matrix and run findMax
		int [][] matrix =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		Matrix2D obj = new Matrix2D();
		/* Max is in the double array's first element and index is in the second element */
		System.out.println("max " + obj.findMax(matrix)[0][0]);
		System.out.println("index " + Arrays.toString(obj.findMax(matrix)[1]));


	}
	
	/**
	 * @param args 2D int array
	 * Finds the maximum number in the array and also the index of max
	 * Returns a double array with max in the first row and the index
	 * in the second row
	 */
	public int [][] findMax(int[][] arr) {
		Integer max = Integer.MIN_VALUE;
		int[] index = new int[]{0, 0};
		int ans[][] = new int[2][0];
		/* Loop through entire array and update max and index */
		for(int i =0; i<arr.length; i++) {
			for(int j =0; j<arr[i].length; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
					index[0] = i;
					index[1] = j;
				}
			}
		}
		/* Prepare array to return */
		ans[0] = new int[]{max};
		ans[1] = index;
		return ans;
		
	}

}
