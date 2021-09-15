/**
 * 
 */
package com.ss.hw2.script;

/**
 * @author Walter Chang
 * Circle class implements shape and has radius
 * Contains calculateArea and display which shows properties of circle
 *
 */
public class Circle implements Shape<Double>{
	private Integer radius;
	
	//No arg constructor sets radius to 0
	Circle(){
		this.radius = 0;
	}
	
	Circle(Integer r){
		//Radius cannot be negative number
		if(r == null || r<0) {
			this.radius = 0;
		}
		else {
			this.radius = r;
		}
	}
 // Area = pi*radius^2
	public Double calculateArea() {
		
		return Math.pow(this.radius, 2)*(3.14);
		
	}
	public void display(){
		System.out.println("Circle of radius " + this.radius);
	}
	
	/* Getters and Setters for radius */
	public Integer getRadius() {
		return radius;
	}

	public void setRadius(Integer radius) {
		this.radius = radius;
	}

}
