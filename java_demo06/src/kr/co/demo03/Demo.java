package kr.co.demo03;

import kr.co.demo03.customer.*; // * 을 쓰면 모든 클래스를 import

public class Demo {

	public static void main(String[] args) {
		/*
		 * 접근제한자
		 * 	   public : 모든 영역에서 접근 가능
		 *     protected : 동일 패키지 또는 후손 관계 까지만 접근 가능
		 *     (default) : 동일 패키지 까지만 접근 가능, 명시하지 않는다
		 *     private : 해당 클래스 내부에서만 접근 가능
		 *     
		 * 클래스 접근 제한자
		 *     public, (default)
		 *     
		 * 멤버 변수 접근 제한자
		 *     public, protected, (default), private
		 *     
		 * 멤버 메서드 접근 제한자
		 *     public, protected, (default), private
		 */
		
		Customer1 cs1 = new Customer1();
		cs1.name = "홍길동";
		cs1.age = 32;
	//	cs1.phone = "010-1234-5678"; private 이라 phone 접근 불가
		
		Customer2 cs2 = new Customer2(); //다른 패키지이기 때문에 접근 불가. 접근제한을 default에서 public으로 변경해야 사용가능
		cs2.name = "홍길동";
	//	cs2.age = 32;     // Customer2를 public 클래스로 바꿔도 age랑 phone이 각각 default와 private라 접근 불가
	//	cs2.phone = "010-1234-5678";
		
		
	}

}
