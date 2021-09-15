/**
 * 
 */
package com.ss.hw2.script;

/**
 * @author Walter Chang
 * Triangle class implements shape
 * Contains calculateArea and display which calculates the area and displays triangle properties
 *
 */
public class Triangle implements Shape<Integer>{
	
	private Integer base;
	private Integer height;
	
	//No arg constructor sets base and height to 0
	Triangle(){
		this.base = 0;
		this.height = 0;
		
	}
	
	Triangle(Integer b, Integer h){
		//Can't have negative base or height
		if(b == null || b <0) {
			this.base = 0;
		}
		else {
			this.base = b;
		}
		if(h == null || h <0) {
			this.height = 0;
		}
		else {
			this.height = h;
		}

	}
	
	// area = b*h/2
	public Integer calculateArea() {
		return base*height/2;
	}
	
	public void display() {
		System.out.println("Triangle of base " + 
	base + " and height "+ height);
	}

	/* Getters and Setters for base and height */
	public Integer getBase() {
		return base;
	}

	public void setBase(Integer base) {
		this.base = base;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	
}
