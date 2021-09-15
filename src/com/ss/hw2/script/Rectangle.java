/**
 * 
 */
package com.ss.hw2.script;

/**
 * @author Walter Chang
 * class Rectangle implements shape and has base and height
 * contains calculate area and display prints properties
 *
 */
public class Rectangle implements Shape<Integer>{

	private Integer height;
	private Integer width;
	
	//No arg constructor sets both lengths to 0
	Rectangle(){
		this.height = 0;
		this.width = 0;
	}
	
	Rectangle(Integer h, Integer w){
		if(h == null || h<0) {
			this.height = 0;
		}
		else {
		this.height = h;
		}
		if(w == null || w<0) {
			this.width = 0;
		}
		else {
		this.width = w;
		}
	}
	// area = w*h
	public Integer calculateArea() {
		if(height == null || width == null) return 0;
		return this.height*this.width;
		
	}
	public void display() {
		System.out.println("Rectangle of width " + (width == null ? 0 : width)
				+ " and height " + (height == null ? 0 : height));
	}
	
	/*Getters and Setters for width and height */
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	
}
