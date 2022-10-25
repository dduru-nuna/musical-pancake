package kr.co.demo05;

public class Demo {

	public static void main(String[] args) {
		/*
		 * 인터페이스(interface)
		 *     추상 클래스 처럼 미완성된 클래스라고 볼 수 있으나 다른점은
		 *     모든 메서드가 추상 메서드이고 멤버 변수를 포함할 수 없다.
		 *     하지만 상수는 포함 가능
		 *     
		 *     - 모든 메서드는 암묵적으로 public abstract 이다.
		 *     - 멤버 변수는 작성할 수 없다.
		 *     - 상수는 작성할 수 있으며 암묵적으로 public static final 이다. 
		 *     - 추상 클래스와 마찬가지로 객체 생성에 사용할 수 없으나 참조 타입으로는
		 *       사용할 수 있다.
		 *     - 인터페이스를 상속하기 위해서는 implements 키워드를 사용한다.
		 *     - 1개 이상의 인터페이스를 implements 할 수 있다.  
		 */
		
		Member m = new Person();
		Staff s = new Person();
		Admin a = new Person();
		
		m.update();
		m.view();
		m.write();
		
		((Staff)m).remove();
		
		/*
		 * 추상클래스와 인터페이스
		 *   추상클래스 - 단일상속
		 *           - extends 사용
		 *           - abstract 메소드 0개 이상
		 *           - 명시적 사용
		 *           - 객체 생성 불가
		 *           - 참조타입 용도
		 *           
		 *   인터페이스 - 다중상속
		 *           - implements 사용
		 *           - 모든 메소드는 abstract
		 *           - 묵시적으로 abstract
		 *           - 객체 생성 불가
		 *           - 참조타입 용도        
		 */
		
	}

}
