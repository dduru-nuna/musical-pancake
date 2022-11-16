package kr.co.demo05;

public class Circle {

	private static final double PI = 3.14;  //static 이란 별도 공간 생김. 정적변수.클래스변수
	private double radius;
	private double area;
	
	public Circle(double radius) {
		this.radius = radius;
		this.area = radius * radius * Circle.PI; //this.PI 로 쓰면 주의표시. PI는 static으로 별도의 클래스가 생겼기에
	}                                            //this 보다는 Circle.PI 가 적합
	                                             //java visualizer 로 쉽게 확인 가능
	public double getRadius() {
		return this.radius;
	}
	
	public double getArea() {
		return this.area;
	}
	
	public double getPI() {
		return Circle.PI;
	}
}
