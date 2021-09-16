/**
 * 
 */
package com.ss.hw3.script;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Walter Chang
 * Takes a file path and a String to append to the end of file
 *
 */
public class AppendText {

	/**
	 * @param args: None
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String path = "./src/com/ss/hw3/script/AppendText.java";

		AppendText obj = new AppendText();
		/* Try Catch method to handle exceptions in main */
		try {
		obj.append(path, "Delete me");
		} catch(IOException e) {
			
		}
	}
	/**
	 * @param args: String path -- path of file to write to
	 * 				String text -- text to append
	 * Rewrites file with existing content then appends param text to the end separated by a newLine
	 */
	public void append(String path, String text) throws IOException {
		File f = new File(path);
		/* If path is valid but is not a file to write to */
		if(!f.isFile()) {
			System.out.println("File not Found");
			return;
		}
		
		/* Save the entire file into a stringbuilder */
		StringBuilder saveFile = new StringBuilder();
		
		/* Use BufferedReader to read from file */
		FileReader fread = new FileReader(path);
		BufferedReader bf = new BufferedReader(fread);
		String s; 
		while((s = bf.readLine()) != null) {
			saveFile.append(s);
			saveFile.append("\n");
		}
		
		/* Initialize BufferedWriter below so as not to delete the file contents*/
		FileWriter fwrite = new FileWriter(path);
		BufferedWriter bw = new BufferedWriter(fwrite);
		bw.write(saveFile.toString());
		bw.write(text);
		
		/* Close both file streams */
		bw.close();
		bf.close();


	}

}
