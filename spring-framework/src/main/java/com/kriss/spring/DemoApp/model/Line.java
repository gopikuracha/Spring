package com.kriss.spring.DemoApp.model;

/**
 * @author kriss
 * 
 */
public class Line implements Shape{

	private Point start;
	private Point end;
	
	public Point getStart() {
		return start;
	}
	
	public void setStart(Point start) {
		this.start = start;
	}

	public Point getEnd() {
		return end;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public void draw() {
		System.out.println("Drawing a Line");
		System.out.println("Start - " + start);
		System.out.println("End - " + end);
	}

}
