package kr.co.exam03;

public class Exam {

	public static void main(String[] args) {
		//Git issue 클래스 만들기 연습 (시계)
		Clock c1 = new Clock(3,15,30);
		c1.dayNight();
		System.out.print(c1.getTime());

	}

}
