/**
 * 
 */
package com.ss.hw2.script;

/**
 * @author Walter Chang
 * Parses command line arguments and adds up their numeric values and chars
 *
 */
public class CommandLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/* Create Float object and StringBuilder */
		Float sum = new Float(0);
		StringBuilder sb = new StringBuilder();
		/* Add numbers together and strings together */
		for(String s : args) {
			try {
				sum += Float.parseFloat(s);
			} catch(NumberFormatException e) {
				sb.append(s);
			}

		}
		System.out.println("Numbers add up to: "+sum);
		System.out.println("Non-numeric values are: " +sb);
		/*Test functionality of Shapes*/
		/*Triangle triangle = new Triangle(4, 5);
		System.out.println(triangle.calculateArea());
		triangle.display();
		
		Rectangle rectangle = new Rectangle(100, 12);
		System.out.println(rectangle.calculateArea());
		rectangle.display();
		
		Circle circle = new Circle();
		System.out.println(circle.calculateArea());
		circle.display();*/

	}

}
