package kr.co.exam01;

public class Exam {

	public static void main(String[] args) {
		/*
		 * 펜(Pen) 클래스를 만들어 본다.
		 * 펜 클래스는 다음의 속성 및 기능을 가진다.
		 *    속성 :  색상, 볼 크기, 잉크 타입
		 *    기능 : 심교체, 심나오게하기, 심들어가게하기
		 *    
		 * 펜은 한번 구입을 하면 색상, 볼 크기, 잉크 타입이 고정되어 있어 별도로 변경할 수 없다.
		 * 
		 * 펜은 어떠한 종류의 심을 사용하느냐에 따라 색상, 잉크 타입을 변경할 수 있다.
		 * 
		 * 펜의 심을 교체 한다고 해도 볼 크기는 변경할 수 없다.
		 * 
		 * 현재 사용하고 있는 펜의 색상, 볼 크기, 잉크 타입을 확인 할 수 있어야한다.
		 */
		
		Pen pen = new Pen("검정색", 0.5, "잉크");
		
		System.out.println("색상 : "+ pen.getColor());
		System.out.println("두께 : "+ pen.getBallSize());
		System.out.println("잉크종류 : "+ pen.getType());
		
		pen.out();
		pen.write("안녕하세요.");
		
		pen.simChange("빨간색", "젤");
		System.out.println("색상 : "+ pen.getColor());
		System.out.println("두께 : "+ pen.getBallSize());
		System.out.println("잉크종류 : "+ pen.getType());
		
		pen.write("안녕하세요.");
	}
}
