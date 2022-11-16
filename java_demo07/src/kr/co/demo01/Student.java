package kr.co.demo01;

public class Student extends Person {  
	      //  자식            부모클래스

	private int year;
	private int classRoom;
	
	// 부모 클래스에서 매개변수 있는 생성자를 사용하고(기본생성자x) 자식 클래스에서 생성자를 사용하려면
	public Student() {   //Demo01의 Student s1 = new Student() -> Person의 매개변수 생성자 -> Student에서 이 구간 순으로 이해 
		super("학생");
	}
	// 이렇게 하면 불편하니 부모 클래스에서는 기본생성자 작성을 해두면 편하다
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getClassRoom() {
		return classRoom;
	}
	
	public void setClassRoom(int classRoom) {
		this.classRoom = classRoom;
	}
	
	/*
	 * 메서드 오버라이드
	 *     기존 부모 클래스가 가지고 있는 메서드를 자식에서 재정의 하여 사용하는 것
	 *     
	 *     기존 부모에 정의한 메서드명, 매개변수 타입/수, 반환타입이 동일해야 한다.
	 *     
	 *     메서드 오버라이드 대상에는 반드시 @Override 어노테이션을 작성하도록 한다.
	 *     (필수는 아니지만 메서드명에 대한 오타를 확인가능)
	 *     
	 *     접근제한자는 부모의 접근제한자 보다 같거나 넓은 범위로 작성해야 한다.
	 *     
	 *     예외처리 부모 보다 같거나 좁은 범위 또는 적은 수의 예외처리여야 한다.
	 *     
	 *     final 키워드가 사용된 메서드에 대해서는 오버라이드를 할 수 없다.
	 */
	@Override
	public void addAge() {
		super.addAge();
		//this.setAge(this.getAge() + 1);
		this.year++;
	}
	
	/*
	 * 오버라이딩과 오버로딩
	 * 
	 * 오버라이딩 - 하위 클래스에서 메서드 정의
	 *         - 메서드 이름 동일, 매개변수 동일(개수,타입), 리턴타입 동일
	 *         - 자식 메서드의 접근 범위가 부모 메서듸 접근 범위보다 넓거나 같아야 함
	 *         - 자식 메서드의 예외 수가 부모 메서드의 예외 수보다 적거나 범위가 좁아야 함
	 * 
	 * 오버로딩  - 같은 클래스에서 메서드 정의
	 *         - 메서드 이름 동일, 매개변수 다름(개수,타입), 리턴타입 상관없음
	 *         - 접근 제어자와 상관 없음
	 *         - 예외처리와 상관 없음
	 */
}
