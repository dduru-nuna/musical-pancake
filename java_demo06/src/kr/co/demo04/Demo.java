package kr.co.demo04;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 캡슐화 : 객체를 외부에서 접근하지 못하게 캡슐처럼 감싸서 보호하는 것
		 *        객체지향 언어의 3대 특징 중 하나(캡슐화, 상속, 다형성)
		 *        
		 * 캡슐화를 위한 기본 원칙
		 *    - 클래스 멤버 변수에 대한 접근제한은 private 로 한다.
		 *    - 클래스 멤버 변수에 대한 연산처리를 목적으로 하는 메서드는 
		 *      클래스 내부에 작성한다.(멤버 메서드)
		 *    - 멤버 메서드는 클래스 밖에서 접근할 수 있도록 public 으로
		 *      설정한다.(멤버 변수에 대한 직접 접근은 안되지만 메서드를 통한
		 *      간접 접근은 허용)
		 *      
		 * 캡슐화 이점
		 *    외부 프로그램이 특정 객체의 멤버 변수에 접근하여 임의로 값을 변경
		 *    하지 못하게 만들어 프로그램의 보안 및 안정성을 높여줄 수 있다.
		 */
		
		Customer cs = new Customer("홍길동", 32, "010-1234-5678");
		
		System.out.println("이름 : " + cs.getName());
		System.out.println("나이 : " + cs.getAge() + " 대");
		System.out.println("연락처 : " + cs.getPhone());
	}

}
