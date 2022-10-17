package kr.co.exam01;

public class Pen {

	private String color;
	private double ballSize;
	private String type;
	private boolean out = false;
	
	public Pen(String color, double ballSize, String type) {
		this.color = color;
		this.ballSize = ballSize;
		this.type = type;
	}
	
	public void simChange(String color, String type) {
		this.color = color;
		this.type = type;
	}
	
	public void out() {
		System.out.println("펜 심이 나왔습니다. 글을 쓸 수 있습니다.");
		this.out = true;
	}
	public void in() {
		System.out.println("펜 심이 들어갔습니다. 글을 쓸 수 없습니다.");
		this.out = false;
	}
	
	public void write(String message) {
		if(out) {
			System.out.printf("%s 색상으로 다음의 글을 작성합니다.\n", this.color);
			System.out.println("\t"+ message);
		} else {
			System.out.println("글을 작성하려면 펜 심이 나오게 하세요.");
		}
	}
	
	public String getColor() {
		return this.color;
	}
	
	public double getBallSize() {
		return this.ballSize;
	}
	
	public String getType() {
		return this.type;
	}
	
}