package kr.co.exam01;

public class Triangle extends Figure {

	@Override
	public double getArea() {
	//	super.setArea();
	//	area = this.area / 2;
		return super.getArea() / 2;
	}
	
}
