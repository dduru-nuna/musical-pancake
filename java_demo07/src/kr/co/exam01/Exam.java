package kr.co.exam01;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 도형 클래스를 상속하는 삼각형, 사각형 클래스를 작성하시오.
		 * 
		 * 삼각형, 사각형 클래스는 다음의 멤버 변수와 메서드가 필요하다.
		 *    - 삼각형
		 *         멤버 변수 : 가로길이, 세로길이
		 *         멤버 메서드 : 넓이 구하기
		 *         
		 *    - 사각형
		 *         멤버 변수 : 가로길이, 세로길이
		 *         멤버 메서드 : 넓이 구하기
		 */
		
		Quadrangle q1 = new Quadrangle();
		
		q1.setWidth(3);
		q1.setLength(4);
		
		System.out.println(q1.getWidth() + "*" + q1.getLength() + "=" + q1.getArea());
		System.out.printf("%.2f%n", q1.getArea());
		
		Triangle t1 = new Triangle();
		
		t1.setWidth(3.5);
		t1.setLength(4.2);
		
		System.out.println(t1.getWidth() + "*" + t1.getLength() + "=" + t1.getArea());
		System.out.printf("%.2f%n", t1.getArea());
	}

}
