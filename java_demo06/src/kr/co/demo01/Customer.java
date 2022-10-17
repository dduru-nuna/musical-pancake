package kr.co.demo01;

public class Customer {
	String name;
	int age;      //멤버변수
	String phone;
	String address;
	                                    // 클래스 객체 -> 설계도,템플릿
	public void pay() {	}               //         |
	                                    //         | 
	public void payCancel() { }         // 인스턴스 객체로 만들어야함 (인스턴스화)
	
	public void phoneChange() {	}      //멤버메서드

}
