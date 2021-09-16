/**
 * 
 */
package com.ss.hw3.script;

import java.io.File;
import java.nio.file.Paths;

/**
 * @author Walter Chang
 * FileDirectoryNames has method to print all files and subdirectories in the given directory
 * Has an example in the main method
 *
 */
public class FileDirectoryNames {

	/**
	 * @param args: None
	 */
	public static void main(String[] args) {
		FileDirectoryNames obj = new FileDirectoryNames();
		obj.printDirectory(".");
	}
	
	/**
	 * @param args: String path -- checks if path is directory and calls 
	 * recursivePrint if so
	 */
	public void printDirectory(String path) {
		File file  = new File(path);
		if(file.list() == null) {
			System.out.println("Error: Directory not found");
			return;
		}
		printRecursive(path, "");
		
			
			
		
	}
	/**
	 * @param args: String path -- path of current directory
	 * 				String indent -- increase as we continue to go down subdirectories
	 */
	public void printRecursive(String path, String indent) {
		File file = new File(path);
		
		/* Check if file list returns null */
		if(file.list() != null) {
			for( String s : file.list()) {
				System.out.println(indent+s);
				printRecursive(path+"/"+s, indent+"  ");
			}
		}
	}

}
