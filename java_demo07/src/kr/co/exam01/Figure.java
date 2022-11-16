package kr.co.exam01;

public class Figure {

	private double width;
	private double length;
	protected double area;
	
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	/*
	public void setArea() {
		this.area = width * length;
	}
	
	public double getArea() {
		return area;
	}*/
	
	public double getArea() {
		return this.width * this.length;
	}
}
