package kr.co.exam03;

public class Food {
	public String name;
	public int price;
	
	
	
	public Food(String name, int price) {
		this.name = name;
//내부에 있는 name(멤버) //외부에서 받아오는 name(지역)
		this.price = price;
		//this 는 인스턴스 객체 식별용이다(자기 자신 식별)
		// this -> 변수 지칭, this() -> 생성자 지칭 : 자기자신 생성자 지칭으로 쓸때는 첫번째 줄에 써야한다.
	}
	

}
