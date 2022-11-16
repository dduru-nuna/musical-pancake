package kr.co.demo02;

public class Customer {
	String name;
	int age;      
	String phone;
	String address;
	
	// 기본 생성자
	public Customer() {}  //이렇게 적어줘야 생성자가 있는 경우에서도 기본 생성자 사용가능
	
	// 매개변수가 있는 생성자
	public Customer(String name) {
		this.name = name;
	}
	 
	// 매개변수가 있는 생성자
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void pay() {	}              
	                                   
	public void payCancel() { }        
	
	public void phoneChange() {	}     

	
}
